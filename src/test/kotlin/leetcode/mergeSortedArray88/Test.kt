package leetcode.mergeSortedArray88

import org.example.leetCode.mergeSortedArray88.Solution
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        val nums1 = intArrayOf(1,2,3,0,0,0)
        val nums2 = intArrayOf(2,5,6)
        solution.merge(nums1, 3, nums2, 3)
        assertArrayEquals(intArrayOf(1,2,2,3,5,6), nums1)
    }

    @Test
    fun `example 2`() {
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf()
        solution.merge(nums1, 1, nums2, 0)
        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun `example 3`() {
        val nums1 = intArrayOf(0)
        val nums2 = intArrayOf(1)
        solution.merge(nums1, 0, nums2, 1)
        assertArrayEquals(intArrayOf(1), nums1)
    }
}
