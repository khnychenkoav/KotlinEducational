package org.example.kotlinBasics.core.syntax.exercises.loops

fun main() {
    var password: String?
    do {
        print("Enter password: ")
        password = readlnOrNull()
    } while (password != "kotlin")

    println("Access granted!")
}
