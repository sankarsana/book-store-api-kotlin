package nrs.sankarsana.bookstore.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.joda.time.DateTime

@Serializable
class BooksDeliveryRemote(
    val date: @Contextual DateTime,
    val items: List<Item>,
) {
    @Serializable
    class Item(
        val bookId: Int,
        val quantity: Int,
    )
}