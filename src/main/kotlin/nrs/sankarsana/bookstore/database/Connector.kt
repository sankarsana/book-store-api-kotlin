package nrs.sankarsana.bookstore.database

import io.ktor.server.config.yaml.*
import org.jetbrains.exposed.sql.Database

fun connectDatabase() {
    val configs = YamlConfig("postgres.yaml")
    val dbName = configs.get(POSTGRES_DB)
    val url = "jdbc:postgresql://localhost:5432/$dbName"
    val user = configs.get(POSTGRES_USER)
    val password = configs.get(POSTGRES_PASSWORD)

    Database.connect(url = url, user = user, password = password)
}

private fun YamlConfig?.get(path: String): String {
    return this?.property(path)?.getString() ?: ""
}

private const val ENV = "services.postgres.environment"
private const val POSTGRES_DB = "$ENV.POSTGRES_DB"
private const val POSTGRES_USER = "$ENV.POSTGRES_USER"
private const val POSTGRES_PASSWORD = "$ENV.POSTGRES_PASSWORD"