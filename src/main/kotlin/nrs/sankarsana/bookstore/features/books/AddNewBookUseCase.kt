package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.features.dto.AddNewBook
import nrs.sankarsana.bookstore.features.dto.AddNewBooksResponse

class AddNewBookUseCase(
    private val repository: BooksRepository,
) {
    suspend operator fun invoke(books: List<AddNewBook>): AddNewBooksResponse {
        return repository.insert(books)
    }
}
