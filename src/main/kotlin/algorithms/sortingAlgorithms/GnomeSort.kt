package org.example.algorithms.sortingAlgorithms

object GnomeSort {
    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        var index = 1
        while (index < list.size) {
            if (index == 0 || list[index] >= list[index - 1]) {
                index++
            } else {
                list.swap(index, index - 1)
                index --
            }
        }
    }

    private fun <T> MutableList<T>.swap(i: Int, j: Int) {
        val tmp = this[i]
        this[i] = this[j]
        this[j] = tmp
    }
}
