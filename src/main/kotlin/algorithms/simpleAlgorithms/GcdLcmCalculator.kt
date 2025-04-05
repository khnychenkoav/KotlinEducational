package org.example.algorithms.simpleAlgorithms

import kotlin.math.abs

object GcdLcmCalculator {
    fun gcd(a: Int, b: Int, isRecursive: Boolean = false): Int {
        val x = abs(a)
        val y = abs(b)

        if (x == 0 && y == 0) {
            throw IllegalArgumentException("GCD(0, 0) is undefined")
        }

        return if (isRecursive) recursiveGcd(x, y) else iterativeGcd(x, y)
    }

    fun lcm(a: Int, b: Int): Int =
        if (a == 0 || b == 0) 0 else abs(a / gcd(a, b) * b)


    private fun recursiveGcd(a: Int, b: Int): Int {
        return if (b == 0) a else recursiveGcd(b, a % b)
    }

    private fun iterativeGcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val temp = y
            y = x % y
            x = temp
        }
        return x
    }
}
