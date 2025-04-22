package org.example.algorithms.graphAlgorithms

import basicStructures.graphs.Graph

object DepthFirstSearch {
    fun <T> traverse(
        graph: Graph<T>,
        start: T,
        visited: MutableSet<T> = mutableSetOf(),
        action: (T) -> Unit = { println(it) }
    ) {
        if (!visited.add(start)) return
        action(start)
        for (neighbor in graph.getNeighbors(start)) {
            traverse(graph, neighbor, visited, action)
        }
    }
}
