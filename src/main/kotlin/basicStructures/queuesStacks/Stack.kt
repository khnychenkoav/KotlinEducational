package basicStructures.queuesStacks

class Stack<T> {
    private val elements: MutableList<T> = mutableListOf()

    fun isEmpty(): Boolean = elements.isEmpty()

    fun size(): Int = elements.size

    fun push(item: T) {
        elements.add(item)
    }

    fun pop(): T {
        if (isEmpty()) {
            throw NoSuchElementException("Stack is empty!")
        }
        return elements.removeAt(elements.size - 1)
    }

    fun peek(): T {
        if (isEmpty()) {
            throw  NoSuchElementException("Stack is empty!")
        }
        return elements[elements.size - 1]
    }

    override fun toString(): String {
        return elements.toString()
    }
}