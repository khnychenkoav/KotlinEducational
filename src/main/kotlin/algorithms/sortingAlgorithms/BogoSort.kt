package org.example.algorithms.sortingAlgorithms

import kotlin.random.Random

object BogoSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        while (!isSorted(list)) {
            list.shuffle(Random.Default)
        }
    }

    private fun <T : Comparable<T>> isSorted(list: List<T>): Boolean {
        for (i in 0 until list.size - 1) {
            if (list[i] > list[i + 1]) return false
        }
        return true
    }
}
