package org.example.basicStructures.trees.avlTree

data class AVLNode<T: Comparable<T>>(
    var value: T,
    var height: Int = 1,
    var left: AVLNode<T>? = null,
    var right: AVLNode<T>? = null,
)