package sample.htmx.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.github.cdimascio.dotenv.Dotenv
import org.jdbi.v3.core.Jdbi
import javax.sql.DataSource

class Database {

    companion object {

        private val dotenv by lazy {
            Dotenv.configure().load()
        }

        private val config by lazy {
            HikariConfig(dotenv.get("DATASOURCE_PROPERTIES"))
        }

        private val dataSource: DataSource by lazy {
            HikariDataSource(config)
        }

        val jdbi: Jdbi by lazy {
            Jdbi.create(dataSource)
        }

        fun init() {
            jdbi.withHandle<Any, Exception> { handle ->
                handle.execute("""
                    create table if not exists todos(
                        id integer primary key auto_increment,
                        description text not null,
                        done boolean default false,
                        created timestamp default now()
                    );
                """.trimIndent())
            }
        }
    }
}
