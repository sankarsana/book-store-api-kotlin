package nrs.sankarsana.bookstore.di

import nrs.sankarsana.bookstore.features.books.BooksDeliveryService
import nrs.sankarsana.bookstore.features.books.BooksRepository
import nrs.sankarsana.bookstore.features.books.BooksService
import org.koin.dsl.module

val booksModule = module {
    single { BooksService(get()) }
    single { BooksDeliveryService(get()) }
    factory { BooksRepository() }
}
