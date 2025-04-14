package org.example.algorithms.sortingAlgorithms

import org.example.basicStructures.queuesStacks.PriorityQueue
import org.example.basicStructures.queuesStacks.Stack

object PatienceSort {
    fun <T : Comparable<T>> sort(list: MutableList<T>) {
        val piles = mutableListOf<Stack<T>>()

        for (item in list) {
            val index = piles.binarySearchBy(item) { it.peek() }
            if (index >= 0) {
                piles[index].push(item)
            } else {
                val insertionPoint = -(index + 1)
                if (insertionPoint == piles.size) {
                    val newPile = Stack<T>()
                    newPile.push(item)
                    piles.add(newPile)
                } else {
                    piles[insertionPoint].push(item)
                }
            }
        }

        val queue = PriorityQueue<IndexedValue<T>>()
        val iterators = piles.map { it.toList().iterator() }

        for ((i, it) in iterators.withIndex()) {
            if (it.hasNext()) {
                queue.push(IndexedValue(i, it.next()))
            }
        }

        var i = 0
        while (!queue.isEmpty()) {
            val smallest = queue.pop()
            list[i++] = smallest.value
            if (iterators[smallest.index].hasNext()) {
                queue.push(IndexedValue(smallest.index, iterators[smallest.index].next()))
            }
        }
    }

    private data class IndexedValue<T : Comparable<T>>(
        val index: Int,
        val value: T
    ) : Comparable<IndexedValue<T>> {
        override fun compareTo(other: IndexedValue<T>): Int {
            return this.value.compareTo(other.value)
        }
    }
}
