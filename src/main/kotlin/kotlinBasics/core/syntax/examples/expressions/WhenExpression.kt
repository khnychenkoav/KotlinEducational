package org.example.kotlinBasics.core.syntax.examples.expressions

fun main() {
    val name = "admin"

    val greet = when (name) {
        "admin" -> "Welcome back, Admin!"
        "anonymous" -> "Hello, mysterious user!"
        else -> "Hi, $name!"
    }
    println(greet)

    val number = 5
    val description = when {
        number < 0 -> "Negative"
        number == 0 -> "Zero"
        number in 1..10 -> "Between 1 and 10"
        else -> "Greater than 10"
    }
    println(description)
}
