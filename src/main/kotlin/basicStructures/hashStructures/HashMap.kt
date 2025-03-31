package org.example.basicStructures.hashStructures

class HashMap<K, V>(private val initialCapacity: Int = 16) {
    private data class Entry<K, V>(val key: K, var value: V)

    private var buckets: Array<MutableList<Entry<K, V>>?> = arrayOfNulls(initialCapacity)
    private var size = 0

    fun isEmpty(): Boolean = size == 0
    fun size(): Int = size

    fun put(key: K, value: V) {
        val index = getIndex(key)
        if (buckets[index] == null) {
            buckets[index] = mutableListOf()
        }
        val bucket = buckets[index]!!
        for (entry in bucket) {
            if (entry.key == key) {
                entry.value = value
                return
            }
        }
        bucket.add(Entry(key, value))
        size++
    }

    fun get(key: K): V? {
        val index = getIndex(key)
        val bucket = buckets[index] ?: return null
        return bucket.firstOrNull { it.key == key }?.value
    }

    fun remove(key: K): Boolean {
        val index = getIndex(key)
        val bucket = buckets[index] ?: return false
        val iterator = bucket.iterator()
        while (iterator.hasNext()) {
            if (iterator.next().key == key) {
                iterator.remove()
                size--
                return true
            }
        }
        return false
    }

    fun containsKey(key: K): Boolean = get(key) != null

    private fun getIndex(key: K): Int {
        return (key.hashCode() and 0x7fffffff) % buckets.size
    }

    override fun toString(): String {
        return buckets.filterNotNull().flatten().joinToString(prefix = "{", postfix = "}") {
            "${it.key}=${it.value}"
        }
    }
}