import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import sample.htmx.App

class SimpleTest {

    @Test
    fun `Should check app`(){
        val app = App()

        Assertions.assertNotNull(app)
    }
}
