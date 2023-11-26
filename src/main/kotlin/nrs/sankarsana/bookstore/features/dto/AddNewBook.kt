package nrs.sankarsana.bookstore.features.dto

import kotlinx.serialization.Serializable

@Serializable
class AddNewBook(
    val id: Int,
    val name: String,
    val shortName: String?,
    val writerId: Int,
    val price: Int,
)