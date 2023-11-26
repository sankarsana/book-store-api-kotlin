package nrs.sankarsana.bookstore.features.dto

import kotlinx.serialization.Serializable

@Serializable
class BooksResponse(
    val databaseVersion: Int,
    val books: List<Book>,
    val writers: List<Writer>,
)