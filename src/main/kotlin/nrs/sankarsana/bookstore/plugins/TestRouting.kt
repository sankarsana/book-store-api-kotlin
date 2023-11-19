package nrs.sankarsana.bookstore.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.testRouting() {
    routing {
        get("/test") {
            call.respondText("Hello World!")
        }
    }
}
