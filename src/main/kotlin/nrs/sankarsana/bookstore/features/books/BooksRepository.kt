package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.database.books.BookEntity
import nrs.sankarsana.bookstore.database.query

class BooksRepository {

    suspend fun getAll(): List<Book> {
        return query {
            BookEntity.all().map(::toBook)
        }
    }

    private fun toBook(entity: BookEntity): Book {
        return Book(
            id = entity.id.value,
            name = entity.name,
        )
    }
}