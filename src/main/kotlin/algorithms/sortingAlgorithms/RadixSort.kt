package org.example.algorithms.sortingAlgorithms

object RadixSort {
    fun sort(list: MutableList<Int>) {
        if (list.isEmpty()) return
        val max = list.max()
        var exp = 1
        while (max / exp > 0) {
            countingSortByDigit(list, exp)
            exp *= 10
        }
    }

    private fun countingSortByDigit(list: MutableList<Int>, exp: Int) {
        val output = MutableList(list.size) { 0 }
        val count = IntArray(10)
        for (num in list) {
            val digit = (num / exp) % 10
            count[digit]++
        }
        for (i in 1 until 10) {
            count[i] += count[i - 1]
        }
        for (i in list.indices.reversed()) {
            val num = list[i]
            val digit = (num / exp) % 10
            output[count[digit] - 1] = num
            count[digit]--
        }

        for (i in list.indices) {
            list[i] = output[i]
        }
    }
}
