package org.example.basicStructures

class UnionFind<T> {
    private val parent = mutableMapOf<T, T>()
    private val rank = mutableMapOf<T, Int>()

    fun makeSet(x: T) {
        if (!parent.containsKey(x)) {
            parent[x] = x
            rank[x] = 0
        }
    }

    fun find(x: T): T {
        require(parent.containsKey(x)) { "Element $x was not found! Call makeSet($x) before find." }
        if (parent[x] != x) {
            parent[x] = find(parent[x]!!)
        }
        return parent[x]!!
    }

    fun unite(x: T, y: T): Boolean {
        require(parent.containsKey(x)) { "Element $x was not found. Call makeSet($x) before unite." }
        require(parent.containsKey(y)) { "Element $y was not found. Call makeSet($y) before unite." }
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return false
        val rankX = rank[rootX]!!
        val rankY = rank[rootY]!!
        when {
            rankX < rankY -> parent[rootX] = rootY
            rankX > rankY -> parent[rootY] = rootX
            else -> {
                parent[rootY] = rootX
                rank[rootX] = rankX + 1
            }
        }
        return true
    }
}