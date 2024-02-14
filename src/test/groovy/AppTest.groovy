import io.github.cdimascio.dotenv.Dotenv
import sample.htmx.App
import spock.lang.Specification

class AppTest extends Specification{

    def "Should check app"(){

        App app = new App()

        expect:
        app != null
    }

    def "should check env"() {
        var dotenv = Dotenv.configure().load()

        expect:
        dotenv.get("MODE") == "test"
    }
}
