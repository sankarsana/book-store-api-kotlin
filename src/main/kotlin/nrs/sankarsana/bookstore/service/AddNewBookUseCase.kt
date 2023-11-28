package nrs.sankarsana.bookstore.service

import nrs.sankarsana.bookstore.dto.AddNewBook
import nrs.sankarsana.bookstore.dto.AddNewBooksResponse
import nrs.sankarsana.bookstore.exception.ForbiddenException

class AddNewBookUseCase(
    private val repository: BooksRepository,
) {
    suspend operator fun invoke(books: List<AddNewBook>): AddNewBooksResponse {
        throw ForbiddenException()
//        return repository.insert(books)
    }
}
