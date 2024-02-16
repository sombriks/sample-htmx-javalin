package sample.htmx

import java.time.LocalDateTime

import sample.htmx.config.Database
import sample.htmx.model.TodoItem
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
        service.list("") != null
    }

    def "should insert todo"() {
        given:
        def result = service.insert(new TodoItem())
        when:
        def check = service.list("")
        then:
        check != null
        check.size() > 0
    }

    def "should update todo"() {
        given:
        def id = service.insert(new TodoItem())
        when:
        def result = service.update(new TodoItem(id, "updated", true, LocalDateTime.now()))
        def check = service.list("updated")
        then:
        check != null
        check.size() > 0

    }

    def "should delete todo"() {
        given:
        def id = service.insert(new TodoItem())
        when:
        def result = service.delete(id)
        def check = service.find(id)
        then:
        thrown(Exception)
    }

}
