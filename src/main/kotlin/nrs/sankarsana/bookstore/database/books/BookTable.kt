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
    val quantityActual = integer("quantity_actual")
}

class BookEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BookEntity>(BooksTable)

    var name by BooksTable.name
    var shortName by BooksTable.shortName
    var writerId by BooksTable.writerId
    var quantityActual by BooksTable.quantityActual
}

fun BookEntity.toDomain() = Book(
    id = id.value,
    name = name,
    shortName = shortName,
    writerId = writerId,
    quantityActual = quantityActual,
)

