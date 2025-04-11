package org.example.algorithms.sortingAlgorithms

import org.example.algorithms.simpleAlgorithms.swap

object FlashSort {
    fun sort(list: MutableList<Double>) {
        val n = list.size
        if (n <= 1) return
        val min = list.min()
        val max = list.max()
        if (min == max) return
        val classNumber = (0.45 * n).toInt().coerceAtLeast(1)
        val prefixArray = classify(list, classNumber, min, max)
        val maxIndex = list.indices.maxByOrNull { list[it] } ?: 0
        list.swap(0, maxIndex)
        permutation(list, prefixArray, classNumber, min, max)
        BinaryInsertionSort.sort(list)
    }

    private fun classify(list: MutableList<Double>, classNumber: Int, min: Double, max: Double): IntArray {
        val prefixArray = IntArray(classNumber) { 0 }
        for (x in list) {
            prefixArray[getBucketIndex(x, classNumber, min, max)]++
        }
        for (i in 1 until classNumber) {
            prefixArray[i] += prefixArray[i - 1]
        }
        return prefixArray
    }
    private fun permutation(
        list: MutableList<Double>,
        prefixArray: IntArray,
        classNumber: Int,
        min: Double,
        max: Double,
    ) {
        val n = list.size
        var count = 0
        var j = 0
        var k = classNumber - 1
        while (count < n - 1) {
            while (j > prefixArray[k] - 1) {
                j++
                if (j < n) {
                    k = getBucketIndex(list[j], classNumber, min, max)
                }
            }
            var flash = list[j]
            while (j != prefixArray[k]) {
                k = getBucketIndex(flash, classNumber, min, max)
                val pos = prefixArray[k] - 1
                val temp = list[pos]
                list[pos] = flash
                flash = temp
                prefixArray[k]--
                count++
            }
        }
    }

    private fun getBucketIndex(x: Double, classNumber: Int, min: Double, max: Double): Int {
        return (((classNumber - 1) * (x - min)) / (max - min)).toInt()
    }
}
