package leetcode.countAndSay38

import org.example.leetCode.countAndSay38.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        assertEquals("1211", solution.countAndSay(4))
    }

    @Test
    fun `base case`() {
        assertEquals("1", solution.countAndSay(1))
    }
}