package org.example.algorithms.simpleAlgorithms

/*
Of course, it would be much better to use text.reversed()
 */

class StringReverser {
    fun reverse(text: String): String {
        val chars = CharArray(text.length)
        for (i in text.indices) {
            chars[i] = text[text.length - 1 - i]
        }
        return String(chars)
    }
}
