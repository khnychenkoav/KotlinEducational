package leetcode.divideArrayIntoEqualPairs2206

import leetCode.divideArrayIntoEqualPairs2206.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        val nums = intArrayOf(3, 2, 3, 2, 2, 2)
        assertEquals(true, solution.divideArray(nums))
    }

    @Test
    fun `example 2`() {
        val nums = intArrayOf(1, 2, 3, 4)
        assertEquals(false, solution.divideArray(nums))
    }
}
