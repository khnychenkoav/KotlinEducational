package org.example.basicStructures.queuesStacks

class Deque<T> {
    private class Node<T>(var data: T, var prev: Node<T>? = null, var next: Node<T>? = null)
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean = size == 0
    fun size(): Int = size

    fun pushFront(item: T) {
        val node = Node(item)
        if (isEmpty()) {
            head = node
            tail = node
        } else {
            node.next = head
            head!!.prev = node
            head = node
        }
        size++
    }

    fun pushBack(item: T) {
        val node = Node(item)
        if (isEmpty()) {
            head = node
            tail = node
        } else {
            node.prev = tail
            tail!!.next = node
            tail = node
        }
        size++
    }

    fun popFront(): T {
        if (isEmpty()) throw NoSuchElementException("Deque is empty!")
        val value = head!!.data
        head = head!!.next
        head?.let { it.prev = null } ?: run { tail = null }
        size--
        return value
    }

    fun popBack(): T {
        if (isEmpty()) throw NoSuchElementException("Deque is empty")
        val value = tail!!.data
        tail = tail!!.prev
        tail?.let { it.next = null } ?: run { head = null }
        size--
        return value
    }

    fun peekFront(): T {
        if (isEmpty()) throw NoSuchElementException("Deque is empty")
        return head!!.data
    }

    fun peekBack(): T {
        if (isEmpty()) throw NoSuchElementException("Deque is empty")
        return tail!!.data
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var current = head
        while (current != null) {
            sb.append(current.data).append(" <-> ")
            current = current.next
        }
        sb.append("null")
        return sb.toString()
    }
}