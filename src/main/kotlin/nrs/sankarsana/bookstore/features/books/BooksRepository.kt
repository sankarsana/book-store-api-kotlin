package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.database.books.BookEntity
import nrs.sankarsana.bookstore.database.books.BookMovementEntity
import nrs.sankarsana.bookstore.database.books.toDomain
import nrs.sankarsana.bookstore.database.query
import nrs.sankarsana.bookstore.features.dto.Book
import nrs.sankarsana.bookstore.features.dto.BookMovement
import nrs.sankarsana.bookstore.features.dto.BookMovementType
import nrs.sankarsana.bookstore.features.dto.BooksDeliveryRemote

class BooksRepository {

    suspend fun getAll(): List<Book> = query {
        BookEntity.all().map { it.toDomain() }
    }

    suspend fun performDelivery(delivery: BooksDeliveryRemote): List<BookMovement> = query {
        return@query delivery.items.map { item ->
            BookMovementEntity.new {
                date = delivery.date
                bookId = item.bookId
                type = BookMovementType.Delivery.name
                quantity = item.quantity
            }.toDomain()
        }
    }
}
