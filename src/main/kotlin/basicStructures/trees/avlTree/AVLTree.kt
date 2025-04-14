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

fun main() {
    val tree = AVLTree<Int>()
    listOf(10, 20, 30, 40, 50, 25).forEach { tree.insert(it) }
    println(tree) // Должно быть сбалансировано
}
