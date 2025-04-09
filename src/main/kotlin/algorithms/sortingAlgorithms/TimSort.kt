package org.example.algorithms.sortingAlgorithms

object TimSort {

    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        if (list.size < 2) return

        val minRun = minRunLength(list.size)

        var index = 0
        while (index < list.size) {
            val runEnd = findAndNormalizeRun(list, index)
            if (runEnd - index < minRun) {
                val end = (index + minRun - 1).coerceAtMost(list.lastIndex)
                insertionSort(list, index, end)
                index = end + 1
            } else {
                index = runEnd
            }
        }

        var size = minRun
        while (size < list.size) {
            var left = 0
            while (left < list.size) {
                val mid = (left + size - 1).coerceAtMost(list.lastIndex)
                val right = (left + 2 * size - 1).coerceAtMost(list.lastIndex)
                if (mid < right) merge(list, left, mid, right)
                left += 2 * size
            }
            size *= 2
        }
    }

    private fun <T : Comparable<T>> findAndNormalizeRun(list: MutableList<T>, start: Int): Int {
        var end = start + 1
        if (end >= list.size) return list.size

        val ascending = list[end] >= list[start]

        while (end < list.lastIndex &&
            (if (ascending) list[end + 1] >= list[end] else list[end + 1] < list[end])
        ) {
            end++
        }

        if (!ascending) list.subList(start, end + 1).reverse()

        return end + 1
    }

    private fun <T : Comparable<T>> insertionSort(list: MutableList<T>, left: Int, right: Int) {
        for (i in left + 1..right) {
            val value = list[i]
            var j = i - 1
            while (j >= left && list[j] > value) {
                list[j + 1] = list[j]
                j--
            }
            list[j + 1] = value
        }
    }

    private fun <T : Comparable<T>> merge(list: MutableList<T>, left: Int, mid: Int, right: Int) {
        val leftPart = list.subList(left, mid + 1).toList()
        val rightPart = list.subList(mid + 1, right + 1).toList()

        var i = 0
        var j = 0
        var k = left

        while (i < leftPart.size && j < rightPart.size) {
            list[k++] = if (leftPart[i] <= rightPart[j]) leftPart[i++] else rightPart[j++]
        }

        while (i < leftPart.size) list[k++] = leftPart[i++]
        while (j < rightPart.size) list[k++] = rightPart[j++]
    }

    private fun minRunLength(n: Int): Int {
        var r = 0
        var length = n
        while (length >= 64) {
            r = r or (length and 1)
            length = length shr 1
        }
        return length + r
    }
}
