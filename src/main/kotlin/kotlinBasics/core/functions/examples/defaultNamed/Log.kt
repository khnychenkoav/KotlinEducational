package org.example.kotlinBasics.core.functions.examples.defaultNamed

fun log(message: String, level: String = "INFO") {
    println("[$level] $message")
}

fun main() {
    log("Started")
    log("Something went wrong", level = "ERROR")
}
