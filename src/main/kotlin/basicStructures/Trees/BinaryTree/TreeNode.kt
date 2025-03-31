package org.example.basicStructures.Trees.BinaryTree

data class TreeNode<T>(
    var value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null,
)
