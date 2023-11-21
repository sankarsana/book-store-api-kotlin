package nrs.sankarsana.bookstore.features.books

import nrs.sankarsana.bookstore.database.books.BookEntity
import nrs.sankarsana.bookstore.database.books.WriterEntity
import nrs.sankarsana.bookstore.features.dto.Book
import nrs.sankarsana.bookstore.features.dto.Writer

fun BookEntity.map(writerEntity: WriterEntity): Book {
    return Book(
        id = id.value,
        name = name,
        writer = writerEntity.map(),
    )
}

private fun WriterEntity.map() = Writer(
    name = this.name,
)