package nrs.sankarsana.bookstore.di

import nrs.sankarsana.bookstore.database.books.BooksRepository
import nrs.sankarsana.bookstore.features.BooksController
import org.koin.dsl.module

val booksModule = module {
    single { BooksController(get()) }
    factory { BooksRepository() }
}
