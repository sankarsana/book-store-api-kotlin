package nrs.sankarsana.bookstore.features.books

import kotlinx.serialization.Serializable

@Serializable
class Book(
    val id: Int,
    val name: String,
)