package basicStructures.priorityStructures

class MaxHeap<T : Comparable<T>> {
    private val heap = mutableListOf<T>()

    fun insert(value: T) {
        heap.add(value)
        siftUp(heap.lastIndex)
    }

    fun peek(): T? = heap.firstOrNull()

    fun remove(): T? {
        if (heap.isEmpty()) return null
        val result = heap.first()
        val last = heap.removeAt(heap.lastIndex)
        if (heap.isNotEmpty()) {
            heap[0] = last
            siftDown(0)
        }
        return result
    }

    private fun siftUp(index: Int) {
        var childIndex = index
        while (childIndex > 0) {
            val parentIndex = (childIndex - 1) / 2
            if (heap[childIndex] <= heap[parentIndex]) break
            swap(childIndex, parentIndex)
            childIndex = parentIndex
        }
    }

    private fun siftDown(index: Int) {
        var parentIndex = index
        val size = heap.size
        while (true) {
            val leftChildIndex = 2 * parentIndex + 1
            val rightChildIndex = 2 * parentIndex + 2
            var largest = parentIndex
            if (leftChildIndex < size && heap[leftChildIndex] > heap[largest]) {
                largest = leftChildIndex
            }
            if (rightChildIndex < size && heap[rightChildIndex] > heap[largest]) {
                largest = rightChildIndex
            }
            if (largest == parentIndex) break
            swap(parentIndex, largest)
            parentIndex = largest
        }
    }

    private fun swap(i: Int, j: Int) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }

    fun size(): Int = heap.size

    fun isEmpty(): Boolean = heap.isEmpty()

    override fun toString(): String = heap.toString()
}
