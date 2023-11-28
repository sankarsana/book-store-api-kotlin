package nrs.sankarsana.bookstore.service

import nrs.sankarsana.bookstore.dto.BooksResponse

class GetBooksUseCase(
    private val repository: BooksRepository,
) {

    suspend operator fun invoke(clientDbVersion: Int?): BooksResponse {
        return repository.getAll(clientDbVersion)
    }
}