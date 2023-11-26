package nrs.sankarsana.bookstore.features.books

import io.ktor.server.application.*
import io.ktor.server.response.*
import nrs.sankarsana.bookstore.features.dto.BooksRequest

class GetBooksController(
    private val getBooksUseCase: GetBooksUseCase,
) {
    suspend operator fun invoke(call: ApplicationCall) {
        val booksRequest = BooksRequest(
            clientDbVersion = call.request.headers["database_version"]?.toInt()
        )
        val response = getBooksUseCase(booksRequest)
        call.respond(response)
    }
}