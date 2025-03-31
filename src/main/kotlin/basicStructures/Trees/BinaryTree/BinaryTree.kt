package org.example.basicStructures.Trees.BinaryTree


class BinaryTree<T: Comparable<T>> {
    private var root: TreeNode<T>? = null

    fun insert(insertVal: T): TreeNode<T> {
        val insertTreeNode = TreeNode<T>(value = insertVal)
        root?.let { insertRec(it, insertTreeNode) } ?: run { root = insertTreeNode }
        return insertTreeNode
    }
    private fun insertRec(current: TreeNode<T>, newTreeNode: TreeNode<T>) {
        when {
            newTreeNode.value < current.value -> {
                if (current.left == null) {
                    current.left = newTreeNode
                } else {
                    insertRec(current.left!!, newTreeNode)
                }
            }
            newTreeNode.value > current.value -> {
                if (current.right == null) {
                    current.right = newTreeNode
                } else {
                    insertRec(current.right!!, newTreeNode)
                }
            }
            else -> {
                throw Exception("This value is already in Tree!")
            }
        }
    }

    fun search(searchVal: T): Boolean {
        return root?.let { searchRec(it, searchVal) } ?: false
    }

    private fun searchRec(current: TreeNode<T>, searchVal: T): Boolean {
        return when {
            searchVal == current.value -> {
                true
            }
            searchVal < current.value -> {
                current.left?.let { searchRec(it, searchVal) } ?: false
            }
            searchVal > current.value -> {
                current.right?.let { searchRec(it, searchVal) } ?: false
            }
            else -> {
                throw Exception("An error occurred!")
            }
        }
    }

    fun delete(valToDelete: T) {
        root = deleteRec(root, valToDelete)
        return
    }

    private fun deleteRec(current: TreeNode<T>?, valToDelete: T): TreeNode<T>? {
        if (current == null) return null
        when {
            valToDelete == current.value -> {
                if (current.left == null) return current.right
                if (current.right == null) return current.left
                val successor = findMin(current.right!!)
                current.value = successor.value
                current.right = deleteRec(current.right, successor.value)

                }
            valToDelete < current.value -> current.left = deleteRec(current.left, valToDelete)
            valToDelete > current.value -> current.right = deleteRec(current.right, valToDelete)
            else -> throw Exception("An error occurred!")
        }
        return current
    }

    private fun findMin(current: TreeNode<T>): TreeNode<T> {
        return if (current.left == null) current else findMin(current.left!!)
    }

    fun preOrderTraversal(current: TreeNode<T>?, listOfTreeNodes: MutableList<TreeNode<T>> = mutableListOf()): MutableList<TreeNode<T>> {
        if (current == null) return listOfTreeNodes
        listOfTreeNodes.add(current)
        preOrderTraversal(current.left, listOfTreeNodes)
        preOrderTraversal(current.right, listOfTreeNodes)
        return listOfTreeNodes
    }

    fun inOrderTraversal(current: TreeNode<T>?, listOfTreeNodes: MutableList<TreeNode<T>> = mutableListOf()): MutableList<TreeNode<T>> {
        if (current == null) return listOfTreeNodes
        inOrderTraversal(current.left, listOfTreeNodes)
        listOfTreeNodes.add(current)
        inOrderTraversal(current.right, listOfTreeNodes)
        return listOfTreeNodes
    }

    fun postOrderTraversal(current: TreeNode<T>?, listOfTreeNodes: MutableList<TreeNode<T>> = mutableListOf()): MutableList<TreeNode<T>> {
        if (current == null) return listOfTreeNodes
        postOrderTraversal(current.left, listOfTreeNodes)
        postOrderTraversal(current.right, listOfTreeNodes)
        listOfTreeNodes.add(current)
        return listOfTreeNodes
    }

    fun breadthFirstTraversal(): MutableList<TreeNode<T>> {
        val result = mutableListOf<TreeNode<T>>()
        val queue = ArrayDeque<TreeNode<T>>()
        root?.let { queue.add(it) } ?: return result
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            result.add(current)
            current.left?.let { queue.add(it) }
            current.right?.let { queue.add(it) }
        }
        return result

    }

}