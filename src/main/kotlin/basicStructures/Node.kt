package org.example.basicStructures

data class Node<T> (
    var data: T,
    var next: Node<T>? = null
)