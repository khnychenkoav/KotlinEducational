package leetcode.findKthBitInNthBinaryString1545

import leetCode.findKthBitInNthBinaryString1545.Solution
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test {
    private val solution = Solution()

    @Test
    fun `example 1`() {
        assertEquals('0', solution.findKthBit(3, 1))
    }

    @Test
    fun `example 2`() {
        assertEquals('1', solution.findKthBit(4, 11))
    }
}
