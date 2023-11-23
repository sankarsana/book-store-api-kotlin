package nrs.sankarsana.bookstore.plugins

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import nrs.sankarsana.bookstore.util.DateTimeSerializer
import org.joda.time.DateTime

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json(json)
    }
}

private val json = Json {
    prettyPrint = true
    isLenient = true
    serializersModule = SerializersModule {
        contextual(DateTime::class, DateTimeSerializer())
    }
}