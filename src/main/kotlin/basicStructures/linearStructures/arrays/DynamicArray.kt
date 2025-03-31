package org.example.basicStructures.linearStructures.arrays

class DynamicArray<T> {
    private var data: Array<Any?> = arrayOfNulls(2)
    private var count = 0

    fun add(value: T) {
        if (count == data.size) resize()
        data[count++] = value
    }

    @Suppress("UNCHECKED_CAST")
    fun get(index: Int): T {
        require(index in 0 until count) { "Index out of bounds" }
        return data[index] as T
    }

    fun size(): Int = count

    private fun resize() {
        val newData = arrayOfNulls<Any?>(data.size * 2)
        for (i in data.indices) {
            newData[i] = data[i]
        }
        data = newData
    }

    override fun toString(): String {
        val actual = data.copyOfRange(0, count)
        return actual.joinToString(prefix = "[", postfix = "]")
    }
}
