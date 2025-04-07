package org.example.algorithms.sortingAlgorithms

import basicStructures.priorityStructures.MaxHeap

object HeapSort {
    fun <T: Comparable<T>> sort(list: MutableList<T>) {
        val heap = MaxHeap<T>()

        for (i in list) {
            heap.insert(i)
        }

        for (i in list.indices.reversed()) {
            val max = heap.remove()
            requireNotNull(max) { "MaxHeap is empty before expected!" }
            list[i] = max
        }
    }
}
