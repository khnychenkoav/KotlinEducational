package org.example.algorithms.sortingAlgorithms

object AmericanFlagSort {
    fun sort(list: MutableList<Int>) {
        if (list.size <= 1) return
        val base = 256
        val maxVal = list.max() ?: 0
        var exp = 1
        while (maxVal / exp >= base) {
            exp *= base
        }
        americanFlagSort(list, 0, list.size, exp, base)
    }

    private fun americanFlagSort(list: MutableList<Int>, start: Int, end: Int, exp: Int, base: Int) {
        if (end - start <= 1 || exp == 0) return

        val counts = IntArray(base) { 0 }
        for (i in start until end) {
            val d = digit(list[i], exp, base)
            counts[d]++
        }

        val positions = IntArray(base)
        positions[0] = start
        for (i in 1 until base) {
            positions[i] = positions[i - 1] + counts[i - 1]
        }
        val bucketStarts = positions.copyOf()
        val bucketCounts = counts.copyOf()

        for (b in 0 until base) {
            while (counts[b] > 0) {
                val i = positions[b]
                var tmp = list[i]
                var d = digit(tmp, exp, base)
                while (i != positions[d]) {
                    val t = list[positions[d]]
                    list[positions[d]] = tmp
                    tmp = t
                    positions[d]++
                    counts[d]--
                    d = digit(tmp, exp, base)
                }
                list[i] = tmp
                positions[b]++
                counts[b]--
            }
        }

        val nextExp = exp / base
        for (b in 0 until base) {
            val bucketStart = bucketStarts[b]
            val bucketEnd = bucketStart + bucketCounts[b]
            americanFlagSort(list, bucketStart, bucketEnd, nextExp, base)
        }
    }

    private fun digit(x: Int, exp: Int, base: Int): Int {
        return (x / exp) % base
    }
}
