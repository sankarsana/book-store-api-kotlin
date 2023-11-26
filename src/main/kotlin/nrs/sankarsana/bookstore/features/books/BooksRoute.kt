package nrs.sankarsana.bookstore.features.books

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nrs.sankarsana.bookstore.features.dto.BooksDeliveryRemote
import nrs.sankarsana.bookstore.util.provide

fun Route.booksRoute() = route("/books") {

    get { provide<GetBooksController>()(call) }

    route("/delivery") {
        post {
            val payload = call.receive<BooksDeliveryRemote>()
            val response = provide<BooksDeliveryService>()(payload)
            call.respond(response)
        }
    }
}
