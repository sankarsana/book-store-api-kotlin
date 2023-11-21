package nrs.sankarsana.bookstore.database

import io.github.cdimascio.dotenv.dotenv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun connectDatabase() {
    val env = dotenv { filename = "postgres.env" }
    val url = env["URL"]
    val user = env["POSTGRES_USER"]
    val password = env["POSTGRES_PASSWORD"]
    Database.connect(url = url, user = user, password = password)
}

suspend fun <T> query(block: () -> T): T = withContext(Dispatchers.IO) {
    transaction { block() }
}