package org.example.basicStructures.stringStructures.trie

class TrieNode {
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
    var isEndOfWord: Boolean = false
}
//бор, префиксное дерево