package org.example.kotlinBasics.core.syntax.examples.loops

fun main() {
    repeat(3) {
        println("This is repetition #${it + 1}")
    }
}
