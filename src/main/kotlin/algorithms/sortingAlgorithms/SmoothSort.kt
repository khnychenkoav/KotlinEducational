package org.example.algorithms.sortingAlgorithms

import org.example.algorithms.simpleAlgorithms.swap

object SmoothSort {
    private val leonardoNumbers = generateLeonardoNumbers(46)

    private data class HeapShape(var trees: Int = 0, var smallestTreeSize: Int = 0) {
        fun transformShapeToIgnoreRightmostHeap() = HeapShape(trees shr 1, smallestTreeSize + 1)

        fun treeBitSet(bit: Int) = (trees and bit) == bit

        fun emptyHeap() = !treeBitSet(1)

        fun hasTrees() = trees > 0

        fun hasTreeOfOrder(order: Int): Boolean {
            val mask = order + 1
            return (trees and mask) == mask
        }

        fun partitionAsSingleTree() {
            trees = trees or 1
            smallestTreeSize = 1
        }

        fun merge() = treeBitSet(3)

        fun mergeTwoSmallestTrees() {
            trees = trees shr 2
            trees = trees or 1
            smallestTreeSize += 2
        }

        fun lastHeapSizeOne() = smallestTreeSize == 1

        fun lastHeapSizeZeroOrOne() = smallestTreeSize <= 1

        fun addSingletonHeapOrderOne() {
            trees = trees shl 1
            trees = trees or 1
            smallestTreeSize = 0
        }

        fun addSingletonHeapOrderZero() {
            trees = trees shl (smallestTreeSize - 1)
            trees = trees or 1
            smallestTreeSize = 1
        }

        fun findPreviousHeap() {
            do {
                trees = trees shr 1
                smallestTreeSize++
            } while (emptyHeap())
        }

        fun findPreviousHeapExhaustively() {
            do {
                trees = trees shr 1
                smallestTreeSize++
            } while (hasTrees() && emptyHeap())
        }

        fun partitionTree() {
            when {
                emptyHeap() -> partitionAsSingleTree()
                merge() -> mergeTwoSmallestTrees()
                smallestTreeSize == 1 -> addSingletonHeapOrderOne()
                else -> addSingletonHeapOrderZero()
            }
        }

        fun exposeLastTwoSubheaps() {
            trees = trees and (1.inv())
            trees = trees shl 2
            trees = trees or 3
            smallestTreeSize -= 2
        }
    }

    fun <T : Comparable<T>> sort(list: MutableList<T>): MutableList<T> {
        if (list.size <= 1) return list

        val shape = HeapShape()

        for (i in list.indices) {
            leonardoHeapAdd(list, 0, i, list.size, shape)
        }

        for (i in list.lastIndex downTo 0) {
            leonardoHeapRemove(list, 0, i, shape)
        }

        return list
    }

    private fun secondChild(root: Int): Int = root - 1

    private fun firstChild(root: Int, treeOrder: Int): Int =
        secondChild(root) - leonardoNumbers[treeOrder - 2]

    private fun <T : Comparable<T>> smallerRootThanChild(list: MutableList<T>, index1: Int, index2: Int): Boolean =
        list[index1] < list[index2]

    private fun <T : Comparable<T>> largerChild(list: MutableList<T>, root: Int, treeOrder: Int): Int {
        val first = firstChild(root, treeOrder)
        val second = secondChild(root)
        return if (smallerRootThanChild(list, first, second)) second else first
    }

    private fun <T : Comparable<T>> rebalanceSingleHeap(list: MutableList<T>, root: Int, treeOrder: Int) {
        var currentRoot = root
        var currentOrder = treeOrder
        while (currentOrder > 1) {
            val first = firstChild(currentRoot, currentOrder)
            val second = secondChild(currentRoot)
            val (largeChild, newOrder) = if (smallerRootThanChild(list, first, second))
                Pair(second, currentOrder - 2)
            else
                Pair(first, currentOrder - 1)
            if (!smallerRootThanChild(list, currentRoot, largeChild)) break
            list.swap(currentRoot, largeChild)
            currentRoot = largeChild
            currentOrder = newOrder
        }
    }

    private fun <T : Comparable<T>> leonardoHeapRectify(
        list: MutableList<T>,
        start: Int,
        finish: Int,
        shape: HeapShape
    ) {
        var index = finish - 1
        while (true) {
            val leftTreeOrder = shape.smallestTreeSize
            if ((index - start) == (leonardoNumbers[leftTreeOrder] - 1)) break

            var nodeIndex = index
            if (shape.smallestTreeSize > 1) {
                val largeChild = largerChild(list, index, shape.smallestTreeSize)
                if (smallerRootThanChild(list, nodeIndex, largeChild))
                    nodeIndex = largeChild
            }

            val leftHeapIndex = index - leonardoNumbers[leftTreeOrder]
            if (!smallerRootThanChild(list, nodeIndex, leftHeapIndex)) {
                break
            } else {
                list.swap(index, leftHeapIndex)
                index = leftHeapIndex
                shape.findPreviousHeap()
            }
        }
        rebalanceSingleHeap(list, index, shape.smallestTreeSize)
    }

    private fun <T : Comparable<T>> leonardoHeapAdd(
        list: MutableList<T>,
        start: Int,
        finish: Int,
        heapFinish: Int,
        shape: HeapShape
    ) {
        shape.partitionTree()

        val smallestTreeSize = shape.smallestTreeSize
        var last = false
        if (smallestTreeSize == 0) {
            if (finish + 1 == heapFinish) last = true
        } else if (smallestTreeSize == 1) {
            if (finish + 1 == heapFinish || (finish + 2 == heapFinish && (shape.trees and 1) == 1))
                last = true
        } else {
            if ((heapFinish - (finish + 1)) < (leonardoNumbers[smallestTreeSize - 1] + 1))
                last = true
        }

        if (!last) {
            rebalanceSingleHeap(list, finish, shape.smallestTreeSize)
        } else {
            leonardoHeapRectify(list, start, finish + 1, shape.copy())
        }
    }

    private fun <T : Comparable<T>> leonardoHeapRemove(
        list: MutableList<T>,
        start: Int,
        finish: Int,
        shape: HeapShape
    ) {
        if (shape.smallestTreeSize <= 1) {
            shape.findPreviousHeapExhaustively()
        } else {
            val heapLeonardoOrder = shape.smallestTreeSize
            shape.exposeLastTwoSubheaps()
            val leftHeap = firstChild(finish, heapLeonardoOrder)
            val rightHeap = secondChild(finish)
            leonardoHeapRectify(list, start, leftHeap + 1, shape.transformShapeToIgnoreRightmostHeap())
            leonardoHeapRectify(list, start, rightHeap + 1, shape.copy())
        }
    }

    private fun generateLeonardoNumbers(limit: Int): List<Int> {
        val list = mutableListOf(1, 1)
        while (list.size < limit) {
            list += list[list.size - 1] + list[list.size - 2] + 1
        }
        return list
    }
}
