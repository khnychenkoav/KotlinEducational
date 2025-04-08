package org.example.algorithms.sortingAlgorithms

object BucketSort {
    fun sort(list: MutableList<Double>, bucketSize: Double = 1.0) {
        if (list.size <= 1) return
        val min = list.min()
        val max = list.max()
        val bucketCount = ((max - min) / bucketSize).toInt() + 1
        val buckets = List(bucketCount) { mutableListOf<Double>() }
        for (num in list) {
            val index = ((num - min) / bucketSize).toInt()
            buckets[index].add(num)
        }

        for (bucket in buckets) {
            BinaryInsertionSort.sort(bucket)
        }

        var index = 0
        for (bucket in buckets) {
            for (num in bucket) {
                list[index++] = num
            }
        }
    }
}
