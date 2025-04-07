package org.example.kotlinBasics.core.syntax.examples.semicolons

fun main() {
    val x = 42
    if (x > 0); // <- ❗ semicolon breaks logic
    println("Positive!") // Always prints!
}
