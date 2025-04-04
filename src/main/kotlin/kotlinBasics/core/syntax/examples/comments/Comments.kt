package org.example.kotlinBasics.core.syntax.examples.comments

// A simple greeting function
fun greet(name: String): String {
    return "Hello, $name!"
}

/*
  This block calculates the sum of two integers.
  It's just an example of multi-line comments.
*/
fun sum(a: Int, b: Int): Int {
    return a + b
}

/**
 * Multiplies two numbers together.
 *
 * @param x First number
 * @param y Second number
 * @return The product of x and y
 */
fun multiply(x: Int, y: Int): Int {
    return x * y
}

fun main() {
    // Single-line comment: calling greet()
    println(greet("Kotlin"))

    // println("This line is disabled for now")

    /*
      This block is disabled during debugging:
      println("Sum: ${sum(2, 3)}")
      println("Multiply: ${multiply(3, 4)}")
    */

    println("Done")
}
