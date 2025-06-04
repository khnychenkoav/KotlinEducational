package org.example.kotlinBasics.core.functions.exercises.defaultNamed

fun log(message: String, level: String = "INFO") {
    // TODO: print the formatted log
}

fun main() {
    log("App started")
    log("Something broke", level = "ERROR")
}
