package org.example.algorithms.graphAlgorithms

import basicStructures.graphs.Graph

object BreadthFirstSearch {
    fun <T> traverse(
        graph: Graph<T>,
        start: T,
        action: (T) -> Unit = { println(it) }
    ) {
        val visited = mutableSetOf<T>()
        val queue = ArrayDeque<T>()

        visited.add(start)
        queue.add(start)

        while (queue.isNotEmpty()) {
            val vertex = queue.removeFirst()
            action(vertex)

            for (neighbor in graph.getNeighbors(vertex)) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor)
                }
            }
        }
    }
}