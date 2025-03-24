package org.example.basicStructures


class BinaryTree<T: Comparable<T>> {
    private var root: Node<T>? = null

    fun insert(insertVal: T): Node<T> {
        val insertNode = Node<T>(value = insertVal)
        root?.let { insertRec(it, insertNode) } ?: run { root = insertNode }
        return insertNode
    }
    private fun insertRec(current: Node<T>, newNode: Node<T>) {
        when {
            newNode.value < current.value -> {
                if (current.left == null) {
                    current.left = newNode
                } else {
                    insertRec(current.left!!, newNode)
                }
            }
            newNode.value > current.value -> {
                if (current.right == null) {
                    current.right = newNode
                } else {
                    insertRec(current.right!!, newNode)
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

    private fun searchRec(current: Node<T>, searchVal: T): Boolean {
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

    private fun deleteRec(current: Node<T>?, valToDelete: T): Node<T>? {
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

    private fun findMin(current: Node<T>): Node<T> {
        return if (current.left == null) current else findMin(current.left!!)
    }

    fun preOrderTraversal(current: Node<T>?, listOfNodes: MutableList<Node<T>> = mutableListOf()): MutableList<Node<T>> {
        if (current == null) return listOfNodes
        listOfNodes.add(current)
        preOrderTraversal(current.left, listOfNodes)
        preOrderTraversal(current.right, listOfNodes)
        return listOfNodes
    }

    fun inOrderTraversal(current: Node<T>?, listOfNodes: MutableList<Node<T>> = mutableListOf()): MutableList<Node<T>> {
        if (current == null) return listOfNodes
        inOrderTraversal(current.left, listOfNodes)
        listOfNodes.add(current)
        inOrderTraversal(current.right, listOfNodes)
        return listOfNodes
    }

    fun postOrderTraversal(current: Node<T>?, listOfNodes: MutableList<Node<T>> = mutableListOf()): MutableList<Node<T>> {
        if (current == null) return listOfNodes
        postOrderTraversal(current.left, listOfNodes)
        postOrderTraversal(current.right, listOfNodes)
        listOfNodes.add(current)
        return listOfNodes
    }

    fun breadthFirstTraversal(): MutableList<Node<T>> {
        val result = mutableListOf<Node<T>>()
        val queue = ArrayDeque<Node<T>>()
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