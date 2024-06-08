@JsExport
class SDUIEngineJS {
    private val engine: SDUIEngine = SDUIEngine()

    @JsName("fib")
    fun fibonacci(number: Int): Int = engine.fibonacci(number)

}

