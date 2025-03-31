package org.example.basicStructures.hashStructures

class LinkedHashSet<K> {
    private val map = LinkedHashMap<K, Unit>()

    fun add(key: K) {
        map.put(key, Unit)
    }

    fun remove(key: K): Boolean = map.remove(key)
    fun contains(key: K): Boolean = map.containsKey(key)
    fun isEmpty(): Boolean = map.isEmpty()
    fun size(): Int = map.size()

    override fun toString(): String = map.toString().replace("=kotlin.Unit", "")
}
