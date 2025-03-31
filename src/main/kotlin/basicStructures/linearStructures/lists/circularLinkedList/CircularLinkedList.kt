package org.example.basicStructures.linearStructures.lists.circularLinkedList

class CircularLinkedList<T> {
    private var head: CircularNode<T>? = null
    private var tail: CircularNode<T>? = null

    fun insert(value: T) {
        val newNode = CircularNode(value)
        if (head == null) {
            head = newNode
            tail = newNode
            newNode.next = newNode
        } else {
            newNode.next = head
            tail!!.next = newNode
            tail = newNode
        }
    }

    fun delete(value: T) {
        if (head == null) return

        var current = head
        var prev: CircularNode<T>? = null

        do {
            if (current!!.data == value) {
                if (current == head && current == tail) {
                    head = null
                    tail = null
                } else {
                    if (current == head) {
                        head = head!!.next
                        tail!!.next = head
                    } else {
                        prev!!.next = current.next
                        if (current == tail) {
                            tail = prev
                        }
                    }
                }
                return
            }
            prev = current
            current = current.next
        } while (current != head)
    }

    fun contains(value: T): Boolean {
        if (head == null) return false
        var current = head
        do {
            if (current!!.data == value) return true
            current = current.next
        } while (current != head)
        return false
    }

    override fun toString(): String {
        if (head == null) return "empty"
        val result = StringBuilder()
        var current = head
        do {
            result.append("${current!!.data} -> ")
            current = current.next
        } while (current != head)
        result.append("(back to head)")
        return result.toString()
    }
}