package org.example.kotlinBasics.core.functions.examples.lambdas

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    val even = numbers.filter { it % 2 == 0 }
    println(even)
}
