package basicStructures.linearStructures.lists.linkedList

data class Node<T> (
    var data: T,
    var next: Node<T>? = null
)