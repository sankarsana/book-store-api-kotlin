package nrs.sankarsana.bookstore.features

import nrs.sankarsana.bookstore.database.books.BookEntity
import nrs.sankarsana.bookstore.database.books.BooksRepository
import org.jetbrains.exposed.sql.transactions.transaction

class BooksController(
    private val repository: BooksRepository,
) {

    fun getAll(): List<Book> {
        return repository.getAll()
    }
}