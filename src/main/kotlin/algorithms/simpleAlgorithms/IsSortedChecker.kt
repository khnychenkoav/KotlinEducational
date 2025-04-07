package org.example.algorithms.simpleAlgorithms

object IsSortedChecker {
    fun <T: Comparable<T>> isSorted(list: List<T>, start: Int = 0, end: Int = list.size): Boolean {
        require(start in 0..end && end <= list.size) {
            "Invalid range: start=$start, end=$end, size=${list.size}"
        }
        for (i in start + 1 until end) {
            if (list[i - 1] > list[i]) return false
        }
        return true
    }
}