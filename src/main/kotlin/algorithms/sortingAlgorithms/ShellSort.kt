package org.example.algorithms.sortingAlgorithms

object ShellSort {
    fun <T: Comparable<T>> sort(
        list: MutableList<T>,
        gapStrategy: (Int) -> List<Int> = ::defaultGapSequence,
    ) {
        val gaps = gapStrategy(list.size)
        for (gap in gaps) {
            for (i in gap until list.size) {
                val temp = list[i]
                var j = i
                while (j >= gap && list[j - gap] > temp) {
                    list[j] = list[j - gap]
                    j -= gap
                }
                list[j] = temp
            }
        }
    }

    private fun defaultGapSequence(size: Int): List<Int> {
        val gaps = mutableListOf<Int>()
        var gap = size / 2
        while (gap > 0) {
            gaps.add(gap)
            gap /= 2
        }
        return gaps
    }
}
