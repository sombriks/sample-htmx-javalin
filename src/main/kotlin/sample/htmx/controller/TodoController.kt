package sample.htmx.controller

import io.javalin.http.Context
import io.javalin.http.bodyAsClass
import org.slf4j.LoggerFactory
import sample.htmx.model.TodoItem
import sample.htmx.service.TodoService

class TodoController(private val service: TodoService = TodoService()) {

    private val logger by lazy { LoggerFactory.getLogger(TodoController::class.java) }

    fun index(ctx: Context): Context {
        logger.info("index")
        val todos = service.list()
        return ctx.render("/templates/velocity/index.vm", mapOf("todos" to todos))
    }

    fun list(ctx: Context): Context {
        logger.info("list")
        val todos = service.list(ctx.queryParam("q"))
        return ctx.render("/templates/velocity/todos/list.vm", mapOf("todos" to todos))
    }

    fun find(ctx: Context): Context {
        logger.info("find")
        val id = ctx.pathParam("id").toLong()
        val todo = service.find(id)
        return ctx.render("/templates/velocity/todos/detail.vm", mapOf("todo" to todo))
    }

    fun insert(ctx: Context): Context {
        logger.info("insert")
        val todo = TodoItem(description = ctx.formParam("description").toString())
        service.insert(todo)
        val todos = service.list()
        return ctx.render("/templates/velocity/todos/list.vm", mapOf("todos" to todos))
    }

    fun update(ctx: Context): Context {
        logger.info("update")
        val todo = ctx.bodyAsClass<TodoItem>()
        val id = ctx.pathParam("id").toLong()
        todo.id = id
        service.update(todo)
        return ctx.render("/templates/velocity/todos/list.vm", mapOf("todos" to service.list()))
    }

    fun delete(ctx: Context): Context {
        logger.info("delete")
        val id = ctx.pathParam("id").toLong()
        service.delete(id)
        return ctx.render("/templates/velocity/todos/list.vm", mapOf("todos" to service.list()))
    }

}
