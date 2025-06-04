package org.example.basicStructures.queuesStacks

import basicStructures.priorityStructures.MinHeap

class PriorityQueue<T: Comparable<T>> {
    private val heap = MinHeap<T>()

    fun isEmpty(): Boolean = heap.isEmpty()
    fun size(): Int = heap.size()

    fun push(item: T) {
        heap.insert(item)
    }

    fun pop(): T = heap.remove() ?: throw NoSuchElementException("PriorityQueue is empty!")
    fun peek(): T = heap.peek() ?: throw NoSuchElementException("PriorityQueue is empty!")
    override fun toString(): String = heap.toString()
}