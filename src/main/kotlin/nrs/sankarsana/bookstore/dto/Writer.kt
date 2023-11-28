package nrs.sankarsana.bookstore.dto

import kotlinx.serialization.Serializable

@Serializable
@Suppress("unused")
class Writer(
    val id: Int,
    val name: String,
)