package nrs.sankarsana.bookstore.features

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nrs.sankarsana.bookstore.database.books.BooksRepository

fun Application.booksRouting() {
    routing {
        get("/books") {
            val controller = BooksController(BooksRepository())
            call.respond(controller.getAll())
        }
    }
}
