package nrs.sankarsana.bookstore.features

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.booksRouting() {
    routing {
        get(PATH) {
            val controller = BooksController(
                repository = BooksRepository(
                    dataSource = BookDataSource()
                )
            )
            val respond = controller.invoke()
            call.respond(respond)
        }
    }
}

private const val PATH = "/books"