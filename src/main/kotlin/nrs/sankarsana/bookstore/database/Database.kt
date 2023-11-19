package nrs.sankarsana.bookstore.database

import io.ktor.server.application.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

suspend fun <T> query(block: () -> T): T = withContext(Dispatchers.IO) {
    transaction { block() }
}

fun connectDatabase(env: ApplicationEnvironment) {
    val url = env.property("db.url")
    val user = env.property("db.user")
    val password = env.property("db.password")

    Database.connect(url = url, user = user, password = password)
}

private fun ApplicationEnvironment.property(path: String): String {
    return config.property(path).getString()
}