package org.example.basicStructures.QueuesStacks

class Queue<T> {
    private val elements: MutableList<T> = mutableListOf()

    fun isEmpty(): Boolean = elements.isEmpty()
    fun size(): Int = elements.size

    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Queue is empty!")
        }
        return elements.removeAt(0)
    }

    fun peel(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Queue is empty!")
        }
        return elements[0]
    }

    override fun toString(): String {
        return elements.toString()
    }
}