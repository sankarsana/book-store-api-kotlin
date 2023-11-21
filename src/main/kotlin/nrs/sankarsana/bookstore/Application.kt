package nrs.sankarsana.bookstore

import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.routing.*
import nrs.sankarsana.bookstore.di.initKoin
import nrs.sankarsana.bookstore.features.books.booksRoute
import nrs.sankarsana.bookstore.plugins.configureSerialization
import nrs.sankarsana.bookstore.database.connectDatabase
import nrs.sankarsana.bookstore.plugins.installStatusPages
import nrs.sankarsana.bookstore.features.test.testRoute

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused") // Executing from /src/main/resources/application.yaml
fun Application.module() {
    install(DefaultHeaders)
    installStatusPages()
    configureSerialization()

    initKoin()

    connectDatabase(environment)

    routing {
        testRoute()
        booksRoute()
    }
}
