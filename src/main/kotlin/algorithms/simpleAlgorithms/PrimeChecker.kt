package org.example.algorithms.simpleAlgorithms

class PrimeChecker {
    private lateinit var sieve: BooleanArray

    private fun generateSieve(limit: Int) {
        sieve = BooleanArray(limit + 1) { true }
        sieve[0] = false
        if (limit >= 1) sieve[1] = false

        for (i in 2..limit) {
            if (sieve[i]) {
                var multiple = i * 2
                while (multiple <= limit) {
                    sieve[multiple] = false
                    multiple += i
                }
            }
        }
    }

    fun isPrime(n: Int): Boolean {
        if (!::sieve.isInitialized || n >= sieve.size) {
            generateSieve(n)
        }
        return sieve[n]
    }
}
