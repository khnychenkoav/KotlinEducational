package leetcode.removeElement27

import org.example.leetCode.removeElement27.Solution
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        val nums = intArrayOf(3,2,2,3)
        val k = solution.removeElement(nums, 3)
        assertEquals(2, k)
        assertArrayEquals(intArrayOf(2,2), nums.copyOf(k).sortedArray())
    }

    @Test
    fun `example 2`() {
        val nums = intArrayOf(0,1,2,2,3,0,4,2)
        val k = solution.removeElement(nums, 2)
        assertEquals(5, k)
        assertArrayEquals(intArrayOf(0,0,1,3,4), nums.copyOf(k).sortedArray())
    }
}
