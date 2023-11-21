package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.database.books.BookEntity
import nrs.sankarsana.bookstore.database.books.WriterEntity
import nrs.sankarsana.bookstore.database.query
import nrs.sankarsana.bookstore.features.dto.Book

class BooksRepository {

    suspend fun getAll(): List<Book> = query {
        BookEntity.all().map { book ->
            val writer = WriterEntity[book.writerId]
            book.map(writer)
        }
    }
}
