package nrs.sankarsana.bookstore.features.dto

import kotlinx.serialization.Serializable

@Serializable
class BooksRequest(
    val clientDbVersion: Int?,
)