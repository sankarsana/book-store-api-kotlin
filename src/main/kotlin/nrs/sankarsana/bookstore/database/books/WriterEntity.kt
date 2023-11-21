package nrs.sankarsana.bookstore.database.books

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

class WriterEntity(id: EntityID<Int>) : IntEntity(id) {
    var name by Writers.name

    companion object : IntEntityClass<WriterEntity>(Writers)
}

private object Writers: IntIdTable() {
    val name = varchar("name", 50)
}
