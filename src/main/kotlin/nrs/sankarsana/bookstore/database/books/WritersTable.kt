package nrs.sankarsana.bookstore.database.books

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

class Writer (id: EntityID<Int>): IntEntity(id) {
    var name by Writers.name
    
    companion object:IntEntityClass<Writer>(Writers)
}

private object Writers: IntIdTable() {
    val name = varchar("name", 50)
}
