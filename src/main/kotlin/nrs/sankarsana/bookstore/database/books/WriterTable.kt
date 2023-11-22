package nrs.sankarsana.bookstore.database.books

import nrs.sankarsana.bookstore.features.dto.Writer
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object WritersTable : IntIdTable() {
    val name = varchar("name", 50)
}

class WriterEntity(id: EntityID<Int>) : IntEntity(id) {
    var name by WritersTable.name

    companion object : IntEntityClass<WriterEntity>(WritersTable)
}

fun WriterEntity.map() = Writer(
    id = id.value,
    name = name,
)