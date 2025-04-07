package org.example.kotlinBasics.core.syntax.exercises.semicolons

fun main() {
    val name = "Kotlin";
    val version = 1.9;

    if (version > 1.0);
    println("You're using a modern Kotlin!") // This line has a logic bug
}
