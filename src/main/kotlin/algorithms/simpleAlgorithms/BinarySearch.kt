package org.example.algorithms.simpleAlgorithms

class BinarySearch {
    fun search(arr: List<Int>, target: Int): Int {
        var left = 0
        var right = arr.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                arr[mid] == target -> return mid
                arr[mid] < target -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }
}