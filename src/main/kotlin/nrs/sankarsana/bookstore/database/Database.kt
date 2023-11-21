package nrs.sankarsana.bookstore.database

import io.ktor.server.config.yaml.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

suspend fun <T> query(block: () -> T): T = withContext(Dispatchers.IO) {
    transaction { block() }
}

fun connectDatabase() {
    val config = YamlConfig("application.yaml")
    val path = "services.db.environment"
    val url = config.get("$path.URL")
    val user = config.get("$path.POSTGRES_USER")
    val password = config.get("$path.POSTGRES_PASSWORD")

    Database.connect(url = url, user = user, password = password)
}

private fun YamlConfig?.get(path: String): String {
    return this?.property(path)?.getString() ?: ""
}