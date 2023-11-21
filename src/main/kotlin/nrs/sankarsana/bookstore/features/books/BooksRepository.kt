package nrs.sankarsana.bookstore.features.books

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import nrs.sankarsana.bookstore.database.books.BookEntity
import nrs.sankarsana.bookstore.database.books.WriterEntity
import nrs.sankarsana.bookstore.features.dto.Book
import org.jetbrains.exposed.sql.transactions.transaction

class BooksRepository {

    suspend fun getAll(): List<Book> = withContext(Dispatchers.IO) {
        transaction {
            BookEntity.all().map { book ->
                val writer = WriterEntity[book.writerId]
                book.map(writer)
            }
        }
    }
}
