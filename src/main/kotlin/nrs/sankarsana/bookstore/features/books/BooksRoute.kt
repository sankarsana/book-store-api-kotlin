package nrs.sankarsana.bookstore.features.books

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nrs.sankarsana.bookstore.util.ApiPath
import org.koin.ktor.ext.inject

fun Route.booksRoute() {

    val controller: BooksService by inject()

    get(ApiPath.BOOKS) {
        call.respond(controller.getAll())
    }
}
