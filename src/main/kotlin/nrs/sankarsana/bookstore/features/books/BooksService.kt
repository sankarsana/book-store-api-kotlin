package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.database.books.BooksRepository

class BooksService(
    private val repository: BooksRepository,
) {

    suspend fun getAll(): List<Book> {
        return repository.getAll()
    }
}