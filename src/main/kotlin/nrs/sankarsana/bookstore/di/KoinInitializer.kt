package nrs.sankarsana.bookstore.di

import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger

fun Application.initKoin() {
    install(Koin) {
        slf4jLogger()
        modules(booksModule)
    }
}