package sample.htmx

import sample.htmx.config.Database
import sample.htmx.service.TodoService
import spock.lang.Shared
import spock.lang.Specification

class ServiceTest extends Specification {

    @Shared
    def service = new TodoService()

    def setup() {
        Database.init()
    }

    def "Should list todos"() {
        expect:
        service.list() != null
    }
}
