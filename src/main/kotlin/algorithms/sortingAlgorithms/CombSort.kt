package org.example.algorithms.sortingAlgorithms

import org.example.algorithms.simpleAlgorithms.swap

object CombSort {
    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        var gap = list.size
        val shrink = 1.3
        var sorted = false
        while (!sorted) {
            gap = (gap / shrink).toInt().coerceAtLeast(1)
            sorted = gap == 1
            for (i in 0 until list.size - gap) {
                if (list[i] > list[i + gap]) {
                    list.swap(i, i + gap)
                    sorted = false
                }
            }
        }
    }
}
