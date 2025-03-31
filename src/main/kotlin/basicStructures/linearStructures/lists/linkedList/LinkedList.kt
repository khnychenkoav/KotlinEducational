package basicStructures.linearStructures.lists.linkedList

class LinkedList<T> {
    private var head: Node<T>? = null

    fun insertStart(data: T) {
        val newNode = Node(data)
        newNode.next = head
        head = newNode
    }

    fun insertEnd(data: T) {
        val newNode = Node(data)
        head?.let {
            var current = it
            while (current.next != null) {
                current = current.next!!
            }
            current.next = newNode
        } ?: run {
            head = newNode
        }
    }

    fun insertAt(index: Int, data: T) {
        if (index <= 0) {
            insertStart(data)
            return
        }
        var current = head
        var currentIndex = 0
        while (current != null &&  currentIndex < index - 1) {
            current = current.next
            currentIndex++
        }
        if (current == null) {
            insertEnd(data)
            return
        }
        val newNode = Node(data)
        newNode.next = current.next
        current.next = newNode
    }

    fun find(data: T): Node<T>? {
        var current = head
        while (current != null) {
            if (current.data == data) {
                return current
            }
            current = current.next
        }
        return null
    }

    fun delete(data: T, occurrence: Int = 1) {
        val dummy = Node(data, head)
        var current = dummy
        var count = 0
        while (current.next != null) {
            if (current.next!!.data == data) {
                count++
                if (count == occurrence) {
                    current.next = current.next!!.next
                    head = dummy.next
                    return
                }
            }
            current = current.next!!
        }
    }

    override fun toString(): String {
        val result = StringBuilder()
        var current = head
        while (current != null) {
            result.append("${current.data} -> ")
            current = current.next
        }
        result.append("null")
        return result.toString()
    }
}