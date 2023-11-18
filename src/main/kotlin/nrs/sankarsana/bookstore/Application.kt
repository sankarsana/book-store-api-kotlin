package nrs.sankarsana.bookstore

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import nrs.sankarsana.bookstore.features.booksRouting
import nrs.sankarsana.bookstore.plugins.testRouting
import nrs.sankarsana.bookstore.plugins.configureSerialization
import nrs.sankarsana.bookstore.plugins.connectDatabase

fun main() {
    connectDatabase()
    
    embeddedServer(
        factory = Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module
    ).start(wait = true)
}

fun Application.module() {
    configureSerialization()
    testRouting()
    booksRouting()
}
