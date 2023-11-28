package nrs.sankarsana.bookstore.dto

import kotlinx.serialization.Serializable

@Serializable
class BooksResponse(
    val databaseVersion: Int,
    val books: List<Book>,
    val writers: List<Writer>,
)