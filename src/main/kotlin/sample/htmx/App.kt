package sample.htmx

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.apibuilder.ApiBuilder.post
import io.javalin.rendering.template.JavalinVelocity
import org.slf4j.LoggerFactory
import sample.htmx.service.Todos

class App(
    private val service: Todos = Todos(),
    private val app: Javalin = Javalin.create { config ->
        config.fileRenderer(JavalinVelocity())
        config.staticFiles.enableWebjars()
        config.router.apiBuilder {
            get("/") { ctx -> ctx.render("/templates/velocity/index.vm", mapOf("world" to "world")) }
            post("/clicked") { ctx ->
                ctx.render("/templates/velocity/xpto.vm")
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
    App().start()
}
