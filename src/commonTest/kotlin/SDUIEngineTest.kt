import kotlin.test.Test
import kotlin.test.assertEquals

class SDUIEngineTest {

    private val engine = SDUIEngine()

    @Test
    fun testFibonacci() {
        assertEquals(1, engine.fibonacci(0))
        assertEquals(1, engine.fibonacci(1))
        assertEquals(2, engine.fibonacci(2))
        assertEquals(3, engine.fibonacci(3))
        assertEquals(5, engine.fibonacci(4))
        assertEquals(8, engine.fibonacci(5))
        assertEquals(13, engine.fibonacci(6))
        assertEquals(21, engine.fibonacci(7))
    }
}