package nrs.sankarsana.bookstore.features

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.booksRouting() {

    val controller by inject<BooksController>()

    routing {
        get("/books") {
            call.respond(controller.getAll())
        }
    }
}
