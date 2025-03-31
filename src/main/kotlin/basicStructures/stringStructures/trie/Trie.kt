package org.example.basicStructures.stringStructures.trie

class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var  current = root
        for (ch in word) {
            current = current.children.computeIfAbsent(ch) { TrieNode() }
        }
        current.isEndOfWord = true
    }

    fun search(word: String): Boolean {
        var current = root
        for (ch in word) {
            current = current.children[ch] ?: return false
        }
        return current.isEndOfWord
    }

    fun startsWith(prefix: String): Boolean {
        var current = root
        for (ch in prefix) {
            current = current.children[ch] ?: return false
        }
        return true
    }
}