package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.features.dto.BooksRequest
import nrs.sankarsana.bookstore.features.dto.BooksResponse

class GetBooksUseCase(
    private val repository: BooksRepository,
) {

    suspend operator fun invoke(request: BooksRequest): BooksResponse {
        return repository.getAll(request.clientDbVersion)
    }
}