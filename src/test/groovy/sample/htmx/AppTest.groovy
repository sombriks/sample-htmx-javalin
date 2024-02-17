package sample.htmx

import io.github.cdimascio.dotenv.Dotenv
import spock.lang.Specification

class AppTest extends Specification {

    def dotenv = Dotenv.configure().load()

    def "should check env is test"() {
        when:
        def mode = dotenv.get("MODE")

        then:
        mode == "test"
    }
}
