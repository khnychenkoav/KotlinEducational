package org.example.algorithms.sortingAlgorithms

import org.example.algorithms.simpleAlgorithms.swap

object StoogeSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        stoogeSort(list, 0, list.size - 1)
    }

    private fun <T : Comparable<T>> stoogeSort(list: MutableList<T>, i: Int, j: Int) {
        if (list[i] > list[j]) list.swap(i, j)
        if (j - i + 1 > 2) {
            val third = (j - i + 1) / 3
            stoogeSort(list, i, j - third)
            stoogeSort(list, i + third, j)
            stoogeSort(list, i, j - third)
        }
    }
}
