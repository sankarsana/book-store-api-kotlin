package nrs.sankarsana.bookstore.features.books

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import nrs.sankarsana.bookstore.features.dto.AddNewBook

class PostBookController(
    private val useCase: AddNewBookUseCase,
) {

    suspend operator fun invoke(call: ApplicationCall) {
        val books = call.receive<List<AddNewBook>>()
        val response = useCase(books)
        call.respond(response)
    }
}