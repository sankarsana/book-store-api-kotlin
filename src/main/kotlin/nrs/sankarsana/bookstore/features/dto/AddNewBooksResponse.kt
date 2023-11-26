package nrs.sankarsana.bookstore.features.dto

import kotlinx.serialization.Serializable

@Serializable
class AddNewBooksResponse(
    val dbVersion: Int,
    val ids: List<Id>,
) {

    @Serializable
    class Id(
        val old: Int,
        val new: Int,
    )
}