package org.example.kotlinBasics.core.syntax.examples.loops

fun main() {
    val items = listOf("apple", "banana", "cherry")
    for ((index, item) in items.withIndex()) {
        println("$index -> $item")
    }
}
