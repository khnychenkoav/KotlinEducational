package org.example.kotlinBasics.core.syntax.exercises.loops

fun main() {
    for (i in 1..5) {
        for (j in 1..5) {
            print("${i * j}\t")
        }
        println()
    }
}
