package nrs.sankarsana.bookstore.di

import nrs.sankarsana.bookstore.features.books.BooksDeliveryService
import nrs.sankarsana.bookstore.features.books.BooksRepository
import nrs.sankarsana.bookstore.features.books.GetBooksController
import nrs.sankarsana.bookstore.features.books.GetBooksUseCase
import org.koin.dsl.module

val booksModule = module {
    factory { GetBooksController(get()) }
    factory { GetBooksUseCase(get()) }
    factory { BooksDeliveryService(get()) }
    factory { BooksRepository() }
}
