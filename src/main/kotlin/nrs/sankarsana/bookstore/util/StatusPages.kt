package nrs.sankarsana.bookstore.util

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import nrs.sankarsana.bookstore.exception.ForbiddenException

fun Application.installStatusPages() = install(StatusPages) {

    exception<ForbiddenException> { call, cause ->
        call.respondText(
            text = cause.message ?: "Access denied",
            status = HttpStatusCode.Forbidden
        )
    }

    exception<Throwable> { call, cause ->
        call.respondText(
            text = cause.message.toString(),
            status = HttpStatusCode.InternalServerError
        )
    }
}