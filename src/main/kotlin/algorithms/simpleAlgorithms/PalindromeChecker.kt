package org.example.algorithms.simpleAlgorithms

class PalindromeChecker {
    fun isPalindrome(text: String): Boolean {
        val len = text.length
        for (i in 0 until len / 2) {
            if (text[i] != text[len - 1 - i]) {
                return false
            }
        }
        return true
    }
}
