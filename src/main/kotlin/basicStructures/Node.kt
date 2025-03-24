package org.example.basicStructures

data class Node<T>(
    var value: T,
    var left: Node<T>? = null,
    var right: Node<T>? = null,
)
