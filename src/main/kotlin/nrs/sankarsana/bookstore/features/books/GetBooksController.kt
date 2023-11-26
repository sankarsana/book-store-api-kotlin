package nrs.sankarsana.bookstore.features.books

import io.ktor.server.application.*
import io.ktor.server.response.*

class GetBooksController(
    private val getBooksUseCase: GetBooksUseCase,
) {
    suspend operator fun invoke(call: ApplicationCall) {
        val dbVersion = call.request.queryParameters["database_version"]?.toInt()
        val response = getBooksUseCase(dbVersion)
        call.respond(response)
    }
}