package org.example.algorithms.sortingAlgorithms

import org.example.algorithms.simpleAlgorithms.BinarySearch

object BinaryInsertionSort {
    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        for (i in 1 until list.size) {
            val key = list[i]
            val insertIndex = BinarySearch.lowerBound(list, key, 0, i)
            require(insertIndex in 0..i) { "insertIndex $insertIndex out of bounds for i=$i" }
            for (j in i - 1 downTo insertIndex) {
                list[j + 1] = list[j]
            }
            list[insertIndex] = key
        }
    }
}
