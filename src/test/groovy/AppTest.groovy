import io.github.cdimascio.dotenv.Dotenv
import sample.htmx.App
import spock.lang.Specification

class AppTest extends Specification {

    def app = new App()
    def dotenv = Dotenv.configure().load()

    def "Should check app"() {
        expect:
        app.controller != null
        app.javalin != null
    }

    def "should check env"() {
        expect:
        dotenv.get("MODE") == "test"
    }
}
