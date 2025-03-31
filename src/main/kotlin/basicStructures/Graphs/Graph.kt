package org.example.basicStructures.Graphs

class Graph<T> {
    private val adjacencyList: MutableMap<T, MutableList<T>> = mutableMapOf()

    fun addVertex(vertex: T) {
        adjacencyList.putIfAbsent(vertex,  mutableListOf())
    }

    fun addEdge(source: T, destination: T, directed: Boolean = false) {
        addVertex(source)
        addVertex(destination)
        adjacencyList[source]?.add(destination)
        if (!directed) {
            adjacencyList[destination]?.add(source)
        }
    }

    fun getNeighbors(vertex: T): List<T> = adjacencyList[vertex] ?: emptyList()

    fun dfs(start: T, visited: MutableSet<T> = mutableSetOf()) {
        if (!visited.add(start)) return
        println(start)
        for (neighbor in getNeighbors(start)) {
            dfs(neighbor, visited)
        }
    }

    fun bfs(start: T) {
        val visited = mutableSetOf<T>()
        val queue: MutableList<T> = mutableListOf()
        visited.add(start)
        queue.add(start)
        while (queue.isNotEmpty()) {
            val vertex = queue.removeAt(0)
            println(vertex)
            for (neighbor in getNeighbors(vertex)) {
                if (visited.add(neighbor)) {
                    queue.add(neighbor)
                }
            }
        }
    }

    override fun toString(): String {
        return adjacencyList.entries.joinToString("\n") { (vertex, neighbors) ->
            "$vertex -> $neighbors"
        }
    }
}