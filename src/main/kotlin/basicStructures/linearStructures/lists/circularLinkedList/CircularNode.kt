package org.example.basicStructures.linearStructures.lists.circularLinkedList

data class CircularNode<T>(
    var data: T,
    var next: CircularNode<T>? = null,
)