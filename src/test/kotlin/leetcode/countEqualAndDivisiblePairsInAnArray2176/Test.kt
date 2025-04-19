package leetcode.countEqualAndDivisiblePairsInAnArray2176

import org.example.leetCode.countEqualAndDivisiblePairsInAnArray2176.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        val nums = intArrayOf(3, 1, 2, 2, 2, 1, 3)
        val k = 2
        assertEquals(4, solution.countPairs(nums, k))
    }

    @Test
    fun `example 2`() {
        val nums = intArrayOf(1, 2, 3, 4)
        val k = 1
        assertEquals(0, solution.countPairs(nums, k))
    }
}
