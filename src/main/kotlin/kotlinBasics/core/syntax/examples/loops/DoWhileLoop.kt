package org.example.kotlinBasics.core.syntax.examples.loops

fun main() {
    var input: String?
    do {
        print("Enter something (type 'exit' to quit): ")
        input = readLine()
        println("You typed: $input")
    } while (input != "exit")
}
