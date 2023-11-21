package nrs.sankarsana.bookstore.features.books

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nrs.sankarsana.bookstore.util.ApiPath
import org.koin.ktor.ext.inject

fun Route.booksRoute() {

    val service by inject<BooksService>()

    get(ApiPath.BOOKS) {
        val response = service(Unit)
        call.respond(response)
    }
}
