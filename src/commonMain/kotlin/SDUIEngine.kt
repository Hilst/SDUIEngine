class SDUIEngine {
    fun fibonacci(n: Int): Int {
        return if (n <= 1) 1 else fibonacci(n - 1) + fibonacci(n - 2)
    }
}