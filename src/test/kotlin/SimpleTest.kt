import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sample.htmx.App
import sample.htmx.config.Database
import sample.htmx.service.TodoService

class SimpleTest {

    @Test
    fun `Should check app`(){
        val app = App(TodoService(Database()))

        Assertions.assertNotNull(app)
    }
}
