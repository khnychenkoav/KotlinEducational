package org.example.kotlinBasics.core.syntax.examples.println

fun main() {
    println("Hello, Kotlin!")

    print("This is on the same ")
    print("line.")
    println()
    println("Now this is a new line.")

    val language = "Kotlin"
    println("We are learning $language!")

    val a = 10
    val b = 15
    println("The sum of $a and $b is ${a + b}")

    println("First Line\nSecond Line")
    println("Indented with tab:\tThis is indented.")

    println("He said: \"Kotlin is awesome!\"")

    val banner = """
        |Welcome to Kotlin!
        |This is a multi-line message.
        |Enjoy learning 🚀
    """.trimMargin()

    println(banner)
}
