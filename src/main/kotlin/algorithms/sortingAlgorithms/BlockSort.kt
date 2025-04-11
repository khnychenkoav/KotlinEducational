package org.example.algorithms.sortingAlgorithms

import kotlin.math.floor
import kotlin.math.sqrt

object BlockSort {
    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        val n = list.size
        if (n <= 1) return
        val blockSize = floor(sqrt(n.toDouble())).toInt().coerceAtLeast(1)
        for (i in 0 until n step blockSize) {
            val end = (i + blockSize).coerceAtMost(n)
            BinaryInsertionSort.sort(list.subList(i, end))
        }
        var currentBlockSize = blockSize
        while (currentBlockSize < n) {
            var i = 0
            while (i < n) {
                val mid = (i + currentBlockSize).coerceAtMost(n)
                val right = (i + 2 * currentBlockSize).coerceAtMost(n)
                if (mid < right) {
                    merge(list, i, mid, right)
                }
                i += 2 * currentBlockSize
            }
            currentBlockSize *= 2
        }
    }

    private fun <T : Comparable<T>> merge(list: MutableList<T>, left: Int, mid: Int, right: Int) {
        val leftPart = list.subList(left, mid).toMutableList()
        var i = 0
        var j = mid
        var k = left

        while (i < leftPart.size && j < right) {
            if (leftPart[i] <= list[j]) {
                list[k++] = leftPart[i++]
            } else {
                list[k++] = list[j++]
            }
        }
        while (i < leftPart.size) {
            list[k++] = leftPart[i++]
        }
    }
}
