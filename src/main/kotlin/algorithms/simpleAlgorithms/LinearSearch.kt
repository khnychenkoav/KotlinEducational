package org.example.algorithms.simpleAlgorithms

class LinearSearch {
    fun search(arr: List<Int>, target: Int): Int {
        for (i in arr.indices) {
            if (arr[i] == target) {
                return i
            }
        }
        return -1
    }
}