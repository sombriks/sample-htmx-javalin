package sample.htmx.service

import org.jdbi.v3.core.Jdbi
import org.slf4j.LoggerFactory
import sample.htmx.config.Database
import sample.htmx.model.TodoItem

class TodoService(val db: Jdbi = Database.jdbi) {

    private val logger by lazy { LoggerFactory.getLogger(TodoService::class.java) }
    fun list(q: String? = ""): List<TodoItem> {
        logger.info("list todos")
        return db.withHandle<List<TodoItem>, Exception> { handle ->
            handle.createQuery(
                """
                select * from todos
                where lower(description) like lower(:q)
            """.trimIndent()
            ).bind("q", "%$q%").mapToBean(TodoItem::class.java).list()
        }
    }

    fun find(id: Long): TodoItem {
        logger.info("find todos")
        return db.withHandle<TodoItem, Exception> { handle ->
            handle.createQuery(
                """
                select * from todos
                where id = :id
            """.trimIndent()
            ).bind("id", id).mapToBean(TodoItem::class.java).one()
        }
    }

    fun insert(item: TodoItem): Int {
        logger.info("insert todo")
        return db.withHandle<Int, Exception> { handle ->
            handle.createUpdate(
                """
                insert into todos(description, done)
                values (:description, :done)
            """.trimIndent()
            ).bindBean(item).execute()
        }
    }

    fun update(item: TodoItem): Int {
        logger.info("update todo")
        return db.withHandle<Int, Exception> { handle ->
            handle.createUpdate(
                """
                update todos
                set description = :description, 
                done = :done where id = :id
            """.trimIndent()
            ).bindBean(item).execute()
        }
    }

    fun delete(id: Long): Int {
        logger.info("delete todo")
        return db.withHandle<Int, Exception> { handle ->
            handle.createUpdate(
                """
                delete from todos where id = :id
            """.trimIndent()
            ).bind("id", id).execute()
        }
    }
}
