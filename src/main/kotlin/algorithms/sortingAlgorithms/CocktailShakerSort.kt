package org.example.algorithms.sortingAlgorithms

import org.example.algorithms.simpleAlgorithms.swap

object CocktailShakerSort {
    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        var start = 0
        var end = list.lastIndex
        var swapped: Boolean
        do {
            swapped = false
            for (i in start until end) {
                if (list[i] > list[i + 1]) {
                    list.swap(i, i + 1)
                    swapped = true
                }
            }

            if (!swapped) break
            swapped = false
            end--

            for (i in end downTo start + 1) {
                if (list[i] < list[i - 1]) {
                    list.swap(i, i - 1)
                    swapped = true
                }
            }
            start++
        } while (swapped)
    }
}
