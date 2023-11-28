package nrs.sankarsana.bookstore.util

import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
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