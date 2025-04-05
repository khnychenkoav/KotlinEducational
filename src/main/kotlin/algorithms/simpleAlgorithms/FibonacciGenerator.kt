package org.example.algorithms.simpleAlgorithms

object FibonacciGenerator {
    fun get(n: Int): Int {
        if (n <= 0) return 0
        if (n == 1) return 1

        var a = 0
        var b = 1
        var result = 0

        for (i in 2..n) {
            result = a + b
            a = b
            b = result
        }

        return result
    }
}
