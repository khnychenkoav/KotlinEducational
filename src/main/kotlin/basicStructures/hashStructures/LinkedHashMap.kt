package org.example.basicStructures.hashStructures

class LinkedHashMap<K, V>(private val initialCapacity: Int = 16) {
    private data class Entry<K, V>(
        val key: K,
        var value: V,
        var prev: Entry<K, V>? = null,
        var next: Entry<K, V>? = null,
    )

    private val buckets: Array<MutableList<Entry<K, V>>?> = arrayOfNulls(initialCapacity)
    private var size = 0

    private var head: Entry<K, V>? = null
    private var tail: Entry<K, V>? = null

    fun isEmpty(): Boolean = size == 0
    fun size(): Int = size

    fun put(key: K, value: V) {
        val index = getIndex(key)
        if (buckets[index] == null) buckets[index] = mutableListOf()
        val bucket = buckets[index]!!
        for (entry in bucket) {
            if (entry.key == key) {
                entry.value = value
                return
            }
        }
        val newEntry = Entry(key, value)
        bucket.add(newEntry)
        appendToOrderList(newEntry)
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
            val entry = iterator.next()
            if (entry.key == key) {
                iterator.remove()
                unlinkFromOrderList(entry)
                size--
                return true
            }
        }
        return false
    }

    fun containsKey(key: K): Boolean = get(key) != null

    private fun appendToOrderList(entry: Entry<K, V>) {
        if (tail == null) {
            head = entry
            tail = entry
        } else {
            tail!!.next = entry
            entry.prev = tail
            tail = entry
        }
    }

    private fun unlinkFromOrderList(entry: Entry<K, V>) {
        val prev = entry.prev
        val next = entry.next
        if (prev != null) prev.next = next else head = next
        if (next != null) next.prev = prev else tail = prev
    }

    private fun getIndex(key: K): Int {
        return (key.hashCode() and 0x7fffffff) % buckets.size
    }

    override fun toString(): String {
        val builder = StringBuilder("{")
        var current = head
        while (current != null) {
            builder.append("${current.key}=${current.value}")
            if (current.next != null) builder.append(", ")
            current = current.next
        }
        builder.append("}")
        return builder.toString()
    }
}