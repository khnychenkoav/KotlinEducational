package basicStructures.linearStructures.lists.doublyLinkedList

data class DoublyNode<T> (
    val data: T,
    var prev: DoublyNode<T>? = null,
    var next: DoublyNode<T>? = null,
)