package sample.htmx

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.rendering.template.JavalinVelocity
import org.slf4j.LoggerFactory
import sample.htmx.config.Database
import sample.htmx.controller.TodoController

class App(
    val controller: TodoController = TodoController(),
    val javalin: Javalin = Javalin.create { config ->
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
        logger.info("start app on port $port")
        javalin.start(port)
    }
}

fun main() {
    Database.init()
    val app = App()
    app.start()
}
