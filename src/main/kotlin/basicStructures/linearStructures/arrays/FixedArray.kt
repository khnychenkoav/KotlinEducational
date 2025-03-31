package org.example.basicStructures.linearStructures.arrays

class FixedArray<T>(private val size: Int) {
    private val data: Array<Any?> = arrayOfNulls(size)

    fun set(index: Int, value: T) {
        require(index in 0 until size) { "Index out of bounds" }
        data[index] = value
    }

    @Suppress("UNCHECKED_CAST")
    fun get(index: Int): T {
        require(index in 0 until size) { "Index out of bounds" }
        return data[index] as T
    }

    fun length(): Int = size

    override fun toString(): String {
        return data.joinToString(prefix = "[", postfix = "]")
    }
}