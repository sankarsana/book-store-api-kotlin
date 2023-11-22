package nrs.sankarsana.bookstore.database

import io.github.cdimascio.dotenv.dotenv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import nrs.sankarsana.bookstore.database.books.BooksTable
import nrs.sankarsana.bookstore.database.books.WritersTable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File

suspend fun <T> query(block: () -> T): T = withContext(Dispatchers.IO) {
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
    )
}

private fun addRows() = transaction {
    val file = File("src/main/resources/sql/content.sql")
    if (file.exists().not()) {
        return@transaction
    }
    val commands = file.readText().split(";")
    for (command in commands) {
        exec(command.trim())
    }
}
