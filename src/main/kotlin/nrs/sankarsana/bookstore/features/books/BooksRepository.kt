package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.database.books.*
import nrs.sankarsana.bookstore.database.query
import nrs.sankarsana.bookstore.features.dto.*
import org.jetbrains.exposed.sql.Transaction

class BooksRepository {

    suspend fun getAll(clientDbVersion: Int?): BooksResponse = query {
        val currentDbVersion = getCurrentDbVersion()
        val version = clientDbVersion ?: DEFAULT_USER_DB_VERSION
        val books = BookEntity.find { BooksTable.version greater version }
        val writers = WriterEntity.find { WritersTable.version greater version }
        BooksResponse(
            databaseVersion = currentDbVersion,
            books = books.map(BookEntity::toDomain),
            writers = writers.map(WriterEntity::toDomain),
        )
    }

    private fun Transaction.getCurrentDbVersion(): Int {
        val stmt = "SELECT last_value FROM version_sequence"
        return exec(stmt) { it.next(); it.getInt(1) } ?: 0
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

    suspend fun insert(books: List<AddNewBook>): AddNewBooksResponse = query {
        val ids = books.map { book ->
            val bookEntity = BookEntity.new {
                name = book.name
                shortName = book.shortName
                writerId = book.writerId
                price = book.price
                quantity = 0
            }
            AddNewBooksResponse.Id(
                old = book.id,
                new = bookEntity.id.value,
            )
        }
        AddNewBooksResponse(
            dbVersion = getCurrentDbVersion(),
            ids = ids
        )
    }

    private companion object {
        const val DEFAULT_USER_DB_VERSION = 0
    }
}
