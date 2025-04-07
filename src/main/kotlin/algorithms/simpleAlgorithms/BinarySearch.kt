package org.example.algorithms.simpleAlgorithms

object BinarySearch {
    fun search(arr: List<Int>, target: Int): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            when {
                arr[mid] == target -> return mid
                arr[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }

    fun <T: Comparable<T>> lowerBound(list: List<T>, key: T, start: Int = 0, end: Int = list.size, checkSorted: Boolean = false): Int {
        var left = start
        var right = end

    }

}