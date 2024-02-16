package sample.htmx

import io.javalin.testtools.JavalinTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import sample.htmx.config.Database

class ApiTest {

    private val app = App()

    @BeforeEach
    fun setup(){
        Database.init()
    }

    @Test
    fun `Should check endpoints`() = JavalinTest.test(app.javalin) { server, client ->
        // basic GET endpoints
        Assertions.assertEquals(200, client.get("/").code)
        Assertions.assertEquals(200, client.get("/todos").code)
    }
}
