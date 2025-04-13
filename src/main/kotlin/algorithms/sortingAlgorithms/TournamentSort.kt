package org.example.algorithms.sortingAlgorithms

object TournamentSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        val n = list.size
        if (n <= 1) return

        val treeSize = 2 * n - 1
        val offset = n - 1
        val tree = Array<TournamentNode<T>?>(treeSize) { null }
        for (i in list.indices) {
            tree[offset + i] = TournamentNode(index = i, value = list[i])
        }
        for (i in offset - 1 downTo 0) {
            val left = tree[2 * i + 1]
            val right = tree[2 * i + 2]
            tree[i] = when {
                left == null -> right
                right == null -> left
                left.value <= right.value -> left
                else -> right
            }
        }
        val sorted = mutableListOf<T>()
        repeat(n) {
            val winner = tree[0] ?: return@repeat
            sorted.add(winner.value)
            var pos = offset + winner.index
            tree[pos] = null

            while (pos > 0) {
                val parent = (pos - 1) / 2
                val left = tree[2 * parent + 1]
                val right = tree[2 * parent + 2]
                tree[parent] = when {
                    left == null -> right
                    right == null -> left
                    left.value <= right.value -> left
                    else -> right
                }
                pos = parent
            }
        }
        for (i in list.indices) {
            list[i] = sorted[i]
        }
    }

    private data class TournamentNode<T : Comparable<T>>(val index: Int, val value: T)
}
