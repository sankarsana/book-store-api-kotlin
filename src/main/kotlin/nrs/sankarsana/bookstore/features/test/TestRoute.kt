package nrs.sankarsana.bookstore.features.test

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import nrs.sankarsana.bookstore.util.ApiPath

fun Route.testRoute() {
    get(ApiPath.TEST) {
        call.respondText("Hello World!")
    }
}
