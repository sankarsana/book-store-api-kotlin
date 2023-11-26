package nrs.sankarsana.bookstore.plugins

import io.ktor.server.plugins.swagger.*
import io.ktor.server.routing.*

fun Route.swaggerRoute() = swaggerUI(
    path = "/swagger",
    swaggerFile = "swagger.yaml",
)
