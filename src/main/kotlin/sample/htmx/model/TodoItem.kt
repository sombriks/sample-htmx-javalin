package sample.htmx.model

import java.time.LocalDateTime

class TodoItem(
    var id: Long? = -1,
    var description: String? = "",
    var done: Boolean? = false,
    var created: LocalDateTime? = LocalDateTime.now()
)
