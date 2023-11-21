package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.features.Service
import nrs.sankarsana.bookstore.features.dto.Book

class BooksService(
    private val repository: BooksRepository,
) : Service<Unit> {

    override suspend operator fun invoke(request: Unit): List<Book> {
        return repository.getAll()
    }
}