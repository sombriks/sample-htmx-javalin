package sample.htmx

import io.javalin.testtools.JavalinTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import sample.htmx.config.Database
import sample.htmx.model.TodoItem

class ApiTest {

    private val app = App()
    private lateinit var todos: List<TodoItem>

    @BeforeEach
    fun setup() {
        Database.init()
        Database.testSeed()
        todos = app.controller.service.list()
    }

    @Test
    fun `Should check TodoItem endpoints`() = JavalinTest.test(app.javalin) { server, client ->
        // basic GET endpoints
        Assertions.assertEquals(200, client.get("/").code)
        Assertions.assertEquals(200, client.get("/todos").code)
        Assertions.assertEquals(200, client.get("/todos/${todos.first().id}").code)
        // new/modify TodoItem
        Assertions.assertEquals(200, client.post("/todos", "description=new todo").code)
        Assertions.assertEquals(200, client.put("/todos/${todos.first().id}", "description=update todo").code)
        // remove
        Assertions.assertEquals(200, client.delete("/todos/${todos.first().id}").code)
    }
}
