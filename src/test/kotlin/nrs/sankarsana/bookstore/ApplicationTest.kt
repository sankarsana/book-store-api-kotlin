package nrs.sankarsana.bookstore

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.testing.*
import nrs.sankarsana.bookstore.features.test.testRoute
import nrs.sankarsana.bookstore.util.ApiPath
import kotlin.test.*

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        application {
            routing {
                testRoute()
            }
        }
        client.get(ApiPath.TEST).apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}
