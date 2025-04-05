package org.example.algorithms.simpleAlgorithms

object FrequencyCounter {
    fun <T> countFrequency(list: List<T>): Map<T, Int> {
        val frequencyMap = mutableMapOf<T, Int>()
        for (item in list) {
            frequencyMap[item] = frequencyMap.getOrDefault(item, 0) + 1
        }
        return frequencyMap
    }
}
