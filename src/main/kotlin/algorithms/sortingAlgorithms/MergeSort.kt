package org.example.algorithms.sortingAlgorithms

object MergeSort {

    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        if (list.size <= 1) return
        mergeSort(list, 0, list.size - 1)
    }

    private fun <T : Comparable<T>> mergeSort(list: MutableList<T>, left: Int, right: Int) {
        if (left < right) {
            val mid = (left + right) / 2
            mergeSort(list, left, mid)
            mergeSort(list, mid + 1, right)
            merge(list, left, mid, right)
        }
    }

    private fun <T: Comparable<T>> merge(
        list: MutableList<T>,
        left: Int,
        mid: Int,
        right: Int,
    ) {
        val leftPart = list.subList(left, mid + 1).toMutableList()
        val rightPart = list.subList(mid + 1, right + 1).toMutableList()

        var i = 0
        var j = 0
        var k = left
        while (i < leftPart.size && j < rightPart.size) {
            if (leftPart[i] <= rightPart[j]) {
                list[k] = leftPart[i]
                i++
            } else {
                list[k] = rightPart[j]
                j++
            }
            k++
        }
        while (i < leftPart.size) {
            list[k] = leftPart[i]
            i++
            k++
        }
        while (j < rightPart.size) {
            list[k] = rightPart[j]
            j++
            k++
        }
    }
}
