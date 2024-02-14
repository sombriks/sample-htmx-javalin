package sample.htmx

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.config.JavalinConfig
import io.javalin.http.bodyAsClass
import io.javalin.rendering.template.JavalinVelocity
import org.slf4j.LoggerFactory
import sample.htmx.config.Database
import sample.htmx.controller.TodoController
import sample.htmx.model.TodoItem
import sample.htmx.service.TodoService

class App(
    private val controller: TodoController = TodoController(),
    private val app: Javalin = Javalin.create { config ->
        config.fileRenderer(JavalinVelocity())
        config.staticFiles.enableWebjars()
        config.router.apiBuilder {
            get("/", controller::index)
            path("/todos") {
                get(controller::list)
                post(controller::insert)
                path("/{id}") {
                    get(controller::find)
                    put(controller::update)
                    delete(controller::delete)
                }
            }
        }
    }
) {

    private val logger by lazy { LoggerFactory.getLogger(App::class.java) }

    fun start(port: Int = 8080) {
        logger.info("start app!")
        app.start(port)
    }
}

fun main() {
    val app = App()
    app.start()
}
