package org.example.kotlinBasics.core.syntax.exercises.mainFunction

/**
 * Task:
 * 1. Create a top-level variable called `developer` with your name.
 * 2. Write a function `introduce()` that prints: "Hi, I'm [developer]".
 * 3. In your `main()` function, call `introduce()`.
 */

const val developer = "Your Name"

fun introduce() {
    println("Hi, I'm $developer")
}

fun main() {
    introduce()
}