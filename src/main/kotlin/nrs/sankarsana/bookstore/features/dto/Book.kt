package nrs.sankarsana.bookstore.features.dto

import kotlinx.serialization.Serializable

@Serializable
@Suppress("unused")
class Book(
    val id: Int,
    val name: String,
    val shortName: String?,
    val writerId: Int,
    val quantityActual: Int,
)