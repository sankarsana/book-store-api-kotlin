package nrs.sankarsana.bookstore.database.books

import nrs.sankarsana.bookstore.database.query
import nrs.sankarsana.bookstore.features.Book

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