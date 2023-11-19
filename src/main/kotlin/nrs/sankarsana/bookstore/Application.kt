package nrs.sankarsana.bookstore

import io.ktor.server.application.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.defaultheaders.*
import nrs.sankarsana.bookstore.di.initKoin
import nrs.sankarsana.bookstore.features.booksRouting
import nrs.sankarsana.bookstore.plugins.configureSerialization
import nrs.sankarsana.bookstore.database.connectDatabase
import nrs.sankarsana.bookstore.plugins.installStatusPages
import nrs.sankarsana.bookstore.plugins.testRouting

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused") // Executing from /src/main/resources/application.yaml
fun Application.module() {
    install(DefaultHeaders)
    installStatusPages()
    configureSerialization()

    initKoin()

    connectDatabase(environment)
    testRouting()
    booksRouting()
}
