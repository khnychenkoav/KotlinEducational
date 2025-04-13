package org.example.algorithms.sortingAlgorithms

import org.example.algorithms.simpleAlgorithms.swap

object OddEvenSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        var sorted = false
        while (!sorted) {
            sorted = true
            for (i in 0 until list.size - 1 step 2) {
                if (list[i] > list[i + 1]) {
                    list.swap(i, i + 1)
                    sorted = false
                }
            }
            for (i in 1 until list.size - 1 step 2) {
                if (list[i] > list[i + 1]) {
                    list.swap(i, i + 1)
                    sorted = false
                }
            }
        }
    }
}
