package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.features.dto.Book

class BooksService(
    private val repository: BooksRepository,
) {

    suspend operator fun invoke(): List<Book> {
        return repository.getAll()
    }
}