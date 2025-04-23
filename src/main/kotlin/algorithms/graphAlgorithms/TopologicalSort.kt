package org.example.algorithms.graphAlgorithms

import basicStructures.graphs.Graph
import basicStructures.queuesStacks.Queue
object TopologicalSort {
    fun <T> sort(graph: Graph<T>): List<T> {
        val vertices = graph.getVertices()
        val inDegree = vertices.associateWith { 0 }.toMutableMap()
        for (u in vertices) {
            for (v in graph.getNeighbors(u)) {
                inDegree[v] = inDegree.getOrDefault(v, 0) + 1
            }
        }
        val queue: Queue<T> = Queue()
        for ((v, deg) in inDegree) {
            if (deg == 0) queue.push(v)
        }
        val result = mutableListOf<T>()
        while (!queue.isEmpty()) {
            val u = queue.pop()
            result.add(u)
            for (v in graph.getNeighbors(u)) {
                inDegree[v] = inDegree[v]!! - 1
                if (inDegree[v] == 0) {
                    queue.push(v)
                }
            }
        }
        if (result.size != vertices.size) {
            throw IllegalArgumentException("Graph contains a cycle, topological sort is impossible")
        }
        return result
    }
}
