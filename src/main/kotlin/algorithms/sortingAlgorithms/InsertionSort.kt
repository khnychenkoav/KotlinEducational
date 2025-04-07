package org.example.algorithms.sortingAlgorithms

object InsertionSort {
    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        for (i in 1 until list.size) {
            val key = list[i]
            var j = i - 1
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j]
                j--
            }
            list[j + 1] = key
        }
    }
}