package org.example.algorithms.sortingAlgorithms

object BubbleSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        for (i in 0 until list.size - 1) {
            for (j in 0 until list.size - i - 1) {
                if (list[j] > list[j + 1]) {
                    val temp = list[j]
                    list[j] = list[j + 1]
                    list[j + 1] = temp
                }
            }
        }
    }
}