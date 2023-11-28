package nrs.sankarsana.bookstore.service

import nrs.sankarsana.bookstore.dto.AddNewBook
import nrs.sankarsana.bookstore.dto.AddNewBooksResponse

class AddNewBookUseCase(
    private val repository: BooksRepository,
) {
    suspend operator fun invoke(books: List<AddNewBook>): AddNewBooksResponse {
        return repository.insert(books)
    }
}
