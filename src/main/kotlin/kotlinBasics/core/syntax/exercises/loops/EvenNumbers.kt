package org.example.kotlinBasics.core.syntax.exercises.loops

fun main() {
    for (i in 1..20) {
        if (i % 2 != 0) continue
        println(i)
    }
}
