package org.example.algorithms.simpleAlgorithms


/*
Of course, it would be much better to use array.reversed()
 */
object ArrayReverser {
    fun <T> reverse(array: List<T>): List<T> {
        val result = mutableListOf<T>()
        for (i in array.indices.reversed()) {
            result.add(array[i])
        }
        return result
    }
}
