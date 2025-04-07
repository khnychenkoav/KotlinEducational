package org.example.kotlinBasics.core.syntax.examples.expressions


fun main() {
    val input = "123a"

    val parsedValue = try {
        input.toInt()
    } catch (e: NumberFormatException) {
        -999
    }

    println("Parsed result: $parsedValue")
}
