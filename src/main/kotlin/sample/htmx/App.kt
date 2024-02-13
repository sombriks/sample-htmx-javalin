package sample.htmx

import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.get
import io.javalin.rendering.template.JavalinVelocity

class App(
    private val app: Javalin = Javalin.create { config ->
        config.fileRenderer(JavalinVelocity())
        config.staticFiles.enableWebjars()
        config.router.apiBuilder {
            get("/") { ctx -> ctx.render("/templates/velocity/index.vm") }
        }
    }
) {

    fun start(port: Int = 8080) {
        app.start(port)
    }
}

fun main() {
    App().start()
}
