package org.example.kotlinBasics.core.syntax.exercises.println

/**
 * Task:
 * 1. Declare variables: your name, age, and favorite quote.
 * 2. Use println() and string interpolation to print a personal introduction.
 * 3. Print your quote inside quotation marks.
 * 4. (Bonus) Create a mini table with 3 items and aligned columns using tabs.
 * 5. (Bonus) Use a multiline string to display a welcome message.
 */

fun main() {
    val name = "Your Name"
    val age = 25
    val quote = "Code is like humor. When you have to explain it, it’s bad."

    println("Hi, I'm $name.")
    println("I'm $age years old.")
    println("My favorite quote is: \"$quote\"")

    // Bonus: Simple table
    println("\nItem\tQty\tPrice")
    println("Book\t2\t$15")
    println("Pen\t5\t$2")
    println("Notebook\t1\t$7")

    // Bonus
    val banner = """
        |===========================
        |  Welcome, $name!
        |  Let's build something great 💡
        |===========================
    """.trimMargin()
    println(banner)
}
