package nrs.sankarsana.bookstore.plugins

import org.jetbrains.exposed.sql.Database

fun connectDatabase() {
    Database.connect(
        url = "jdbc:postgresql://localhost:5432/books",
        user = "postgres",
        password = "12345",
    )
}