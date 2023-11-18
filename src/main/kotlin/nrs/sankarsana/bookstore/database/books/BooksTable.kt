package nrs.sankarsana.bookstore.database.books

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable


class BookEntity(id: EntityID<Int>): IntEntity(id) {
    var name by BooksTable.name
    var writerId by BooksTable.writerId
    
    companion object: IntEntityClass<BookEntity>(BooksTable)
}

private object BooksTable: IntIdTable("books") {
    val name = varchar("name", 100)
    val writerId = integer("writer_id")
}

