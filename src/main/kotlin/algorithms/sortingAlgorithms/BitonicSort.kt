package org.example.algorithms.sortingAlgorithms

import org.example.algorithms.simpleAlgorithms.swap


object BitonicSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>, ascending: Boolean = true) {
        bitonicSort(list, 0, list.size, ascending)
    }

    private fun <T : Comparable<T>> bitonicSort(list: MutableList<T>, low: Int, count: Int, ascending: Boolean) {
        if (count > 1) {
            val mid = count / 2
            bitonicSort(list, low, mid, true)
            bitonicSort(list, low + mid, count - mid, false)
            bitonicMerge(list, low, count, ascending)
        }
    }

    private fun <T : Comparable<T>> bitonicMerge(list: MutableList<T>, low: Int, count: Int, ascending: Boolean) {
        if (count > 1) {
            val k = greatestPowerOfTwoLessThan(count)
            for (i in low until low + count - k) {
                if ((ascending && list[i] > list[i + k]) || (!ascending && list[i] < list[i + k])) {
                    list.swap(i, i + k)
                }
            }
            bitonicMerge(list, low, k, ascending)
            bitonicMerge(list, low + k, count - k, ascending)
        }
    }

    private fun greatestPowerOfTwoLessThan(n: Int): Int {
        var k = 1
        while (k < n) {
            k = k shl 1
        }
        return k shr 1
    }
}
