package org.example.algorithms.sortingAlgorithms

object SelectionSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        for (i in 0 until list.size - 1) {
            var minIndex = i
            for (j in i + 1 until list.size) {
                if (list[j] < list[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                val temp = list[i]
                list[i] = list[minIndex]
                list[minIndex] = temp
            }
        }
    }
}