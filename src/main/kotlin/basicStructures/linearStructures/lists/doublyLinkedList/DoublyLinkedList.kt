package basicStructures.linearStructures.lists.doublyLinkedList

class DoublyLinkedList<T> {
    private var head: DoublyNode<T>? = null
    private var tail: DoublyNode<T>? = null

    fun insertStart(value: T) {
        val newNode = DoublyNode(value, null, head)
        if (head != null) {
            head!!.prev = newNode
        } else {
            tail = newNode
        }
        head = newNode
    }

    fun insertEnd(value: T) {
        val newNode = DoublyNode(value, tail, null)
        if (tail != null) {
            tail!!.next = newNode
        } else {
            head = newNode
        }
        tail = newNode
    }

    fun insertAt(value: T, index: Int) {
        if (index <= 0) {
            insertStart(value)
            return
        }
        var current = head
        var currentIndex = 0
        while (current != null && currentIndex < index - 1) {
            current = current.next
            currentIndex++
        }
        if (current?.next == null) {
            insertEnd(value)
            return
        }
        val newNode = DoublyNode(value)
        val nextNode = current.next
        newNode.prev = current
        newNode.next = nextNode
        current.next = newNode
        nextNode?.prev = newNode
    }

    fun delete(value: T) {
        var current = head
        while (current != null) {
            if (current.data == value) {
                if (current.prev != null) {
                    current.prev!!.next = current.next
                } else {
                    head = current.next
                }
                if (current.next != null) {
                    current.next!!.prev = current.prev
                } else {
                    tail = current.prev
                }
                return
            }
            current = current.next
        }
    }

    fun find(value: T): DoublyNode<T>? {
        var current = head
        while (current != null) {
            if (current.data == value) return current
            current = current.next
        }
        return null
    }

    override fun toString(): String {
        val result = StringBuilder()
        var current = head
        while (current != null) {
            result.append("${current.data} <-> ")
            current = current.next
        }
        result.append("null")
        return result.toString()
    }
}