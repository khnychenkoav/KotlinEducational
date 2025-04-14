package basicStructures.trees.avlTree

import org.example.basicStructures.trees.avlTree.AVLNode

class AVLTree<T : Comparable<T>> {

    private var root: AVLNode<T>? = null

    fun insert(value: T) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: AVLNode<T>?, value: T): AVLNode<T> {
        if (node == null) return AVLNode(value)

        when {
            value < node.value -> node.left = insertRec(node.left, value)
            value > node.value -> node.right = insertRec(node.right, value)
            else -> throw IllegalArgumentException("Value $value already exists")
        }

        updateHeight(node)
        return rebalance(node)
    }


    private fun height(node: AVLNode<T>?): Int = node?.height ?: 0

    private fun updateHeight(node: AVLNode<T>) {
        node.height = 1 + maxOf(height(node.left), height(node.right))
    }

    private fun balanceFactor(node: AVLNode<T>): Int {
        return height(node.left) - height(node.right)
    }

    private fun rebalance(node: AVLNode<T>): AVLNode<T> {
        val balance = balanceFactor(node)

        return when {
            balance > 1 -> {
                val leftChild = node.left ?: return node
                if (balanceFactor(leftChild) >= 0) {
                    rotateRight(node)
                } else {
                    rotateLeftRight(node)
                }
            }
            balance < -1 -> {
                val rightChild = node.right ?: return node
                if (balanceFactor(rightChild) <= 0) {
                    rotateLeft(node)
                } else {
                    rotateRightLeft(node)
                }
            }
            else -> node
        }
    }

    private fun rotateRight(y: AVLNode<T>): AVLNode<T> {
        val x = y.left!!
        val T2 = x.right

        x.right = y
        y.left = T2

        updateHeight(y)
        updateHeight(x)

        return x
    }

    private fun rotateLeft(x: AVLNode<T>): AVLNode<T> {
        val y = x.right!!
        val T2 = y.left

        y.left = x
        x.right = T2

        updateHeight(x)
        updateHeight(y)

        return y
    }

    private fun rotateLeftRight(node: AVLNode<T>): AVLNode<T> {
        node.left = rotateLeft(node.left!!)
        return rotateRight(node)
    }

    private fun rotateRightLeft(node: AVLNode<T>): AVLNode<T> {
        node.right = rotateRight(node.right!!)
        return rotateLeft(node)
    }

    fun contains(value: T): Boolean {
        return searchRec(root, value)
    }

    private fun searchRec(node: AVLNode<T>?, value: T): Boolean {
        if (node == null) return false
        return when {
            value == node.value -> true
            value < node.value -> searchRec(node.left, value)
            else -> searchRec(node.right, value)
        }
    }

    fun delete(value: T) {
        root = deleteRec(root, value)
    }

    private fun deleteRec(node: AVLNode<T>?, value: T): AVLNode<T>? {
        if (node == null) return null
        when {
            value < node.value -> node.left = deleteRec(node.left, value)
            value > node.value -> node.right = deleteRec(node.right, value)
            else -> {
                if (node.left == null || node.right == null) {
                    return node.left ?: node.right
                } else {
                    val successor = findMin(node.right!!)
                    node.value = successor.value
                    node.right = deleteRec(node.right, successor.value)
                }
            }
        }

        updateHeight(node)
        return rebalance(node)
    }

    private fun findMin(node: AVLNode<T>): AVLNode<T> {
        var current = node
        while (current.left != null) {
            current = current.left!!
        }
        return current
    }

    fun inOrder(): List<T> {
        val result = mutableListOf<T>()
        inOrderTraversal(root, result)
        return result
    }

    private fun inOrderTraversal(node: AVLNode<T>?, result: MutableList<T>) {
        if (node == null) return
        inOrderTraversal(node.left, result)
        result.add(node.value)
        inOrderTraversal(node.right, result)
    }

    override fun toString(): String {
        return inOrder().joinToString(" -> ", prefix = "[", postfix = "]")
    }
}
