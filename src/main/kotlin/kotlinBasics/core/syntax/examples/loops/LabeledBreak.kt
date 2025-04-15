package org.example.kotlinBasics.core.syntax.examples.loops

fun main() {
    outer@ for (i in 1..3) {
        for (j in 1..3) {
            if (j == 2) break@outer
            println("i=$i, j=$j")
        }
    }
}
