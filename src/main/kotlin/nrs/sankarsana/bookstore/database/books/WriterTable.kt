package nrs.sankarsana.bookstore.database.books

import nrs.sankarsana.bookstore.features.dto.Writer
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