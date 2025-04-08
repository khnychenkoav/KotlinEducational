package org.example.algorithms.sortingAlgorithms

object CountingSort {
    fun sort(list: MutableList<Int>) {
        if (list.isEmpty()) return
        val min = list.min()
        val max = list.max()
        val range = max - min + 1
        val count = IntArray(range)
        for (num in list) {
            count[num - min]++
        }
        var index = 0
        for (i in count.indices) {
            repeat(count[i]) {
                list[index++] = i + min
            }
        }
    }
}
