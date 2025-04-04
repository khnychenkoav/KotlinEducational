package org.example.kotlinBasics.core.syntax.exercises.comments

/**
 * TASK:
 * 1. Add proper comments to this code.
 * 2. Use all three types: single-line, multi-line, and KDoc.
 * 3. Try commenting out one of the function calls in main().
 */

// This function needs documentation!
fun welcome(name: String): String {
    return "Welcome, $name!"
}

// This one too
fun square(n: Int): Int {
    return n * n
}

fun main() {
    println(welcome("Developer"))

    println("The square of 7 is ${square(7)}")

    // Uncomment to test this alternative:
    // println(welcome("Tester"))
}
