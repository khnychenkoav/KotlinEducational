package org.example.basicStructures.StringStructures.Trie

class TrieNode {
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
    var isEndOfWord: Boolean = false
}
//бор, префиксное дерево