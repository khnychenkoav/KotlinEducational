package org.example.basicStructures.hashStructures

class HashSet<K> {
    private val map = HashMap<K, Unit>()

    fun add(key: K) {
        map.put(key, Unit)
    }

    fun remove(key: K): Boolean {
        return map.remove(key)
    }

    fun contains(key: K): Boolean {
        return map.containsKey(key)
    }

    fun isEmpty(): Boolean = map.isEmpty()
    fun size(): Int = map.size()

    override fun toString(): String {
        return map.toString()
            .replace("=kotlin.Unit", "")
    }
}
