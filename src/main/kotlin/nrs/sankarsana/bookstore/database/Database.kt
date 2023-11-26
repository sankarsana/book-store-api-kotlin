package nrs.sankarsana.bookstore.database

import io.github.cdimascio.dotenv.dotenv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import nrs.sankarsana.bookstore.database.books.BooksMovementTable
import nrs.sankarsana.bookstore.database.books.BooksTable
import nrs.sankarsana.bookstore.database.books.WritersTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Transaction
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.io.FileNotFoundException

suspend fun <T> query(block: Transaction.() -> T): T = withContext(Dispatchers.IO) {
    transaction { block() }
}

fun connectDatabase() {
    val env = dotenv { filename = "postgres.env" }
    val url = env["URL"]
    val user = env["POSTGRES_USER"]
    val password = env["POSTGRES_PASSWORD"]

    Database.connect(url = url, user = user, password = password)

    if (isDatabaseEmpty()) {
        createTables()
        addRows()
    }
}

private fun isDatabaseEmpty() = transaction {
    SchemaUtils.listTables().isEmpty()
}

private fun createTables() = transaction {
    SchemaUtils.create(
        BooksTable,
        WritersTable,
        BooksMovementTable,
    )
}

private fun addRows() = transaction {
    try {
        File("src/main/resources/sql/content_filler.sql")
            .readText()
            .split(";")
            .forEach { exec(it.trim()) }
    } catch (e: FileNotFoundException) {
        e.printStackTrace()
    }
}
