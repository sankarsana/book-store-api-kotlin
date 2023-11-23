package nrs.sankarsana.bookstore.features.books

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nrs.sankarsana.bookstore.features.dto.BooksDeliveryRemote
import nrs.sankarsana.bookstore.util.ApiPath
import nrs.sankarsana.bookstore.util.inject

fun Route.booksRoute() {

    get(ApiPath.BOOKS) {
        val service by inject<BooksService>()
        call.respond(service())
    }

    post(ApiPath.BOOKS_DELIVERY) {
        val payload = call.receive<BooksDeliveryRemote>()
        val service by inject<BooksDeliveryService>()
        val response = service(payload)
        call.respond(response)
    }
}
