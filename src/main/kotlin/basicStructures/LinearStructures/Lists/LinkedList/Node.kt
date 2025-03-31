package org.example.basicStructures.LinearStructures.Lists.LinkedList

data class Node<T> (
    var data: T,
    var next: Node<T>? = null
)