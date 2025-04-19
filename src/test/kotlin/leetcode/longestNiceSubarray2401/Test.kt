package leetcode.longestNiceSubarray2401

import leetCode.longestNiceSubarray2401.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        val nums = intArrayOf(1, 3, 8, 48, 10)
        assertEquals(3, solution.longestNiceSubarray(nums))
    }

    @Test
    fun `example 2`() {
        val nums = intArrayOf(3, 1, 5, 11, 13)
        assertEquals(1, solution.longestNiceSubarray(nums))
    }
}
