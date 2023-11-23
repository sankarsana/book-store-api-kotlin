package nrs.sankarsana.bookstore.features.dto

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import org.joda.time.DateTime

@Serializable
data class BookMovement(
    val id: Int,
    val date: @Contextual DateTime,
    val bookId: Int,
    val type: BookMovementType,
    val quantity: Int,
)
