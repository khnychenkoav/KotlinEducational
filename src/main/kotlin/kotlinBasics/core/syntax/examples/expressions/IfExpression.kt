package org.example.kotlinBasics.core.syntax.examples.expressions

fun main() {
    val x = 10
    val y = 20
    val max = if (x > y) x else y
    println("max is $max")

    val message = if (max > 15) {
        println("We have a fairly big number!")
        "Big number"
    } else {
        println("We have a smaller number or they're equal.")
        "Small number"
    }
    println("message: $message")
}
