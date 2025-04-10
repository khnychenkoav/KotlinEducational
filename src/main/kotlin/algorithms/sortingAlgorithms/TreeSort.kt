package org.example.algorithms.sortingAlgorithms

import org.example.basicStructures.trees.binaryTree.BinaryTree

object TreeSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        val tree = BinaryTree<T>()
        list.forEach { tree.insert(it) }

        val sorted = tree.inOrderTraversal(tree.getRoot() ?: return)
        for (i in list.indices) {
            list[i] = sorted[i].value
        }
    }
}
