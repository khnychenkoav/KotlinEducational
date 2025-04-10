package org.example.algorithms.simpleAlgorithms

fun <T> MutableList<T>.swap(i: Int, j: Int) {
    if (i == j) return
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}
