package sample.htmx.service

import org.slf4j.LoggerFactory
import sample.htmx.config.Database
import sample.htmx.model.TodoItem

class TodoService(private val db: Database = Database()) {

    private val logger by lazy { LoggerFactory.getLogger(TodoService::class.java) }
    fun list(q: String? = ""): List<TodoItem> {
        logger.info("list todos")
        return listOf(TodoItem(1, "test"), TodoItem(2, "test"))
    }

    fun find(id: Long): TodoItem {
        logger.info("find todos")
        return TodoItem(id, "test")
    }

    fun insert(item: TodoItem): String {
        logger.info("insert todo")
        return "OK"
    }

    fun update(item: TodoItem): String {
        logger.info("update todo")
        return "OK"
    }

    fun delete(id: Long): String {
        logger.info("delete todo")
        return "OK"
    }
}
