package nrs.sankarsana.bookstore.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Application.testRouting() {
    routing {
        get(PATH) {
            val respond = Test("Hello World!")
            call.respond(respond)
        }
    }
}

@Serializable
private data class Test(
    val text: String
)

private const val PATH = "/test"
