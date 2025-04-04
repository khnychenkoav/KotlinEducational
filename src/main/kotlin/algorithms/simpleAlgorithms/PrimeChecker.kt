package org.example.algorithms.simpleAlgorithms

import kotlin.math.sqrt

class PrimeChecker {
    private lateinit var sieve: BooleanArray

    private fun generateSieve(limit: Int) {
        sieve = BooleanArray(limit + 1) { true }
        sieve[0] = false
        sieve[1] = false
        for (i in 2..sqrt(limit.toDouble()).toInt()) {
            if (sieve[i]) {
                for (j in i * i..limit step i) {
                    sieve[j] = false
                }
            }
        }
    }

    fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        if (!::sieve.isInitialized || n >= sieve.size) {
            generateSieve(n)
        }
        return sieve[n]
    }
}
