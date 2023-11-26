package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.features.dto.BooksResponse

class GetBooksUseCase(
    private val repository: BooksRepository,
) {

    suspend operator fun invoke(clientDbVersion: Int?): BooksResponse {
        return repository.getAll(clientDbVersion)
    }
}