package org.example.algorithms.simpleAlgorithms

class MinMaxFinder {
    fun findMinMax(numbers: List<Int>): Pair<Int, Int>? {
        if (numbers.isEmpty()) return null

        var min = numbers[0]
        var max = numbers[0]

        for (i in 1 until numbers.size) {
            if (numbers[i] < min) min = numbers[i]
            if (numbers[i] > max) max = numbers[i]
        }

        return Pair(min, max)
    }
}
