package leetcode.minimumCostWalkInWeightedGraph3108

import leetCode.minimumCostWalkInWeightedGraph3108.Solution
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        val n = 5
        val edges = arrayOf(
            intArrayOf(0,1,7),
            intArrayOf(1,3,7),
            intArrayOf(1,2,1)
        )
        val query = arrayOf(
            intArrayOf(0,3),
            intArrayOf(3,4)
        )
        assertArrayEquals(intArrayOf(1, -1), solution.minimumCost(n, edges, query))
    }

    @Test
    fun `example 2`() {
        val n = 3
        val edges = arrayOf(
            intArrayOf(0,2,7),
            intArrayOf(0,1,15),
            intArrayOf(1,2,6),
            intArrayOf(1,2,1)
        )
        val query = arrayOf(
            intArrayOf(1,2)
        )
        assertArrayEquals(intArrayOf(0), solution.minimumCost(n, edges, query))
    }
}
