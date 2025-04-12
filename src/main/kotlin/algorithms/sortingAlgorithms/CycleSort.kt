package org.example.algorithms.sortingAlgorithms

object CycleSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        val n = list.size
        for (cycleStart in 0 until n - 1) {
            var item = list[cycleStart]
            var pos = cycleStart
            for (i in cycleStart + 1 until n) {
                if (list[i] < item) pos++
            }
            if (pos == cycleStart) continue

            while (item == list[pos]) {
                pos++
            }
            if (pos != cycleStart) {
                val temp = list[pos]
                list[pos] = item
                item = temp
            }
            while (pos != cycleStart) {
                pos = cycleStart
                for (i in cycleStart + 1 until n) {
                    if (list[i] < item) pos++
                }
                while (item == list[pos]) {
                    pos++
                }
                if (item != list[pos]) {
                    val temp = list[pos]
                    list[pos] = item
                    item = temp
                }
            }
        }
    }
}
