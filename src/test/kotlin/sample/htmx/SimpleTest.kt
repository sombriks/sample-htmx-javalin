package sample.htmx

import io.github.cdimascio.dotenv.Dotenv
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SimpleTest {

    private val app = App()
    private val dotenv = Dotenv.configure().load()

    @Test
    fun `Should check app`() {
        Assertions.assertNotNull(app.javalin)
        Assertions.assertNotNull(app.controller)
        Assertions.assertNotNull(app.controller.service)
        Assertions.assertNotNull(app.controller.service.db)
    }

    @Test
    fun `Should check env`() {
        Assertions.assertEquals("test", dotenv.get("MODE"))
    }
}
