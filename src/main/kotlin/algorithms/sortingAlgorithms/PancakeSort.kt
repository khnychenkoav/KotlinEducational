package org.example.algorithms.sortingAlgorithms

object PancakeSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        val n = list.size
        for (currSize in n downTo 2) {
            var maxIndex = 0
            for (i in 1 until currSize) {
                if (list[i] > list[maxIndex]) {
                    maxIndex = i
                }
            }
            if (maxIndex != currSize - 1) {
                flip(list, maxIndex)
                flip(list, currSize - 1)
            }
        }
    }

    private fun <T> flip(list: MutableList<T>, i: Int) {
        var start = 0
        var end = i
        while (start < end) {
            val temp = list[start]
            list[start] = list[end]
            list[end] = temp
            start++
            end--
        }
    }
}
