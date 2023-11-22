package nrs.sankarsana.bookstore.database.books

import nrs.sankarsana.bookstore.features.dto.Book
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object BooksTable : IntIdTable("books") {
    val name = varchar("name", 100)
    val shortName = varchar("short_name", 10).nullable()
    val writerId = integer("writer_id")
}

class BookEntity(id: EntityID<Int>) : IntEntity(id) {
    var name by BooksTable.name
    var shortName by BooksTable.shortName
    var writerId by BooksTable.writerId

    companion object : IntEntityClass<BookEntity>(BooksTable)
}

fun BookEntity.toBook() = Book(
    id = id.value,
    name = name,
    shortName = shortName,
    writerId = writerId,
)

