package org.example.algorithms.sortingAlgorithms

object QuickSort {
    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        if (list.size <= 1) return
        quickSort(list, 0, list.size - 1)
    }

    private fun <T: Comparable<T>> quickSort(list: MutableList<T>, low: Int, high: Int) {
        if (low < high) {
            val pivotIndex = partition(list, low, high)
            quickSort(list, 0, pivotIndex - 1)
            quickSort(list, pivotIndex + 1, high)
        }
    }

    private fun <T: Comparable<T>> partition(list: MutableList<T>, low: Int, high: Int): Int {
        val pivot = list[high]
        var i = low - 1
        for (j in low until high) {
            if (list[j] < pivot) {
                i++
                list.swap(i, j)
            }
        }
        list.swap(i + 1, high)
        return i + 1
    }

    private fun <T> MutableList<T>.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
