package leetcode.countTheNumberOfFairPairs2563

import org.example.leetCode.countTheNumberOfFairPairs2563.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        val nums = intArrayOf(0, 1, 7, 4, 4, 5)
        val lower = 3
        val upper = 6
        assertEquals(6L, solution.countFairPairs(nums, lower, upper))
    }

    @Test
    fun `example 2`() {
        val nums = intArrayOf(1, 7, 9, 2, 5)
        val lower = 11
        val upper = 11
        assertEquals(1L, solution.countFairPairs(nums, lower, upper))
    }
}
