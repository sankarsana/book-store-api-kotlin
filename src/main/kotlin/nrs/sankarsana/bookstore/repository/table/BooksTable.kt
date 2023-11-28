package nrs.sankarsana.bookstore.repository.table

import nrs.sankarsana.bookstore.dto.Book
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object BooksTable : IntIdTable("books") {
    val name = varchar("name", 100)
    val shortName = varchar("short_name", 10).nullable()
    val writerId = integer("writer_id")
    val price = integer("price")
    val quantity = integer("quantity")
    val version = integer("version").default(0)
}

class BookEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<BookEntity>(BooksTable)

    var name by BooksTable.name
    var shortName by BooksTable.shortName
    var writerId by BooksTable.writerId
    var price by BooksTable.price
    var quantity by BooksTable.quantity
}

fun BookEntity.toDomain() = Book(
    id = id.value,
    name = name,
    shortName = shortName,
    writerId = writerId,
    price = price,
    quantity = quantity,
)

