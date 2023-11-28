package nrs.sankarsana.bookstore

import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.routing.*
import nrs.sankarsana.bookstore.di.initKoin
import nrs.sankarsana.bookstore.repository.connectDatabase
import nrs.sankarsana.bookstore.service.booksRoute
import nrs.sankarsana.bookstore.util.configureSerialization
import nrs.sankarsana.bookstore.util.installStatusPages
import nrs.sankarsana.bookstore.util.swaggerRoute

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("UNUSED")
fun Application.module() {
    install(DefaultHeaders)
    installStatusPages()
    configureSerialization()

    initKoin()

    connectDatabase()

    routing {
        booksRoute()

        swaggerRoute()
    }
}
