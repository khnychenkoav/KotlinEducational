package org.example.kotlinBasics.core.syntax.examples.loops

fun main() {
    val names = listOf("Kotlin", "Java", "Python")
    for (name in names) {
        println("Language: $name")
    }
}
