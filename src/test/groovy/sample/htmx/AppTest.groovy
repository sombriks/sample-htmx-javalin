package sample.htmx

import io.github.cdimascio.dotenv.Dotenv
import spock.lang.Specification

class AppTest extends Specification {

    def app = new App()
    def dotenv = Dotenv.configure().load()

    def "Should check app got dependencies properly injected"() {
        expect:
        app.javalin != null
        app.controller != null
        app.controller.service != null
        app.controller.service.db != null
    }

    def "should check env is test"() {
        when:
        def mode = dotenv.get("MODE")

        then:
        mode == "test"
    }
}
