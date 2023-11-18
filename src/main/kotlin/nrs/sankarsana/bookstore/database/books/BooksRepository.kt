package nrs.sankarsana.bookstore.database.books

import nrs.sankarsana.bookstore.features.Book
import org.jetbrains.exposed.sql.transactions.transaction

class BooksRepository {

    fun getAll(): List<Book> {
        return transaction {
            BookEntity.all().map(::toBook)
        }
    }

    private fun toBook(entity: BookEntity): Book {
        return Book(
            id = entity.id.value,
            name = entity.name,
        )
    }
}