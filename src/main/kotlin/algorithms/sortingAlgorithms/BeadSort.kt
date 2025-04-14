package org.example.algorithms.sortingAlgorithms

object BeadSort {
    fun sort(list: MutableList<Int>) {
        if (list.any { it < 0 }) {
            throw IllegalArgumentException("BeadSort doesn't work with negative numbers!")
        }
        val max = list.maxOrNull() ?: return
        if (max == 0) return
        val n = list.size
        val beads = Array(n) { BooleanArray(max) { false } }
        for (i in list.indices) {
            for (j in 0 until list[i]) {
                beads[i][j] = true
            }
        }
        for (j in 0 until max) {
            var count = 0
            for (i in 0 until n) {
                if (beads[i][j]) count++
                beads[i][j] = false
            }
            for (i in n - count until n) {
                beads[i][j] = true
            }
        }
        for (i in list.indices) {
            var count = 0
            for (j in 0 until max) {
                if (beads[i][j]) count++
            }
            list[i] = count
        }
    }
}

