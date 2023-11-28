package nrs.sankarsana.bookstore.repository.table

import nrs.sankarsana.bookstore.dto.Writer
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object WritersTable : IntIdTable() {
    val name = varchar("name", 50)
    val version = integer("version").default(0)
}

class WriterEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<WriterEntity>(WritersTable)

    var name by WritersTable.name
}

fun WriterEntity.toDomain() = Writer(
    id = id.value,
    name = name,
)