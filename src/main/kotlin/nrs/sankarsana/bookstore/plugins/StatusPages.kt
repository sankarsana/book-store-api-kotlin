package nrs.sankarsana.bookstore.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.installStatusPages() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = cause.message.toString(), status = HttpStatusCode.InternalServerError)
        }
    }
}