package org.example.leetCode.minimumSizeSubarraySum209

import kotlin.math.min

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a

whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0



Constraints:

    1 <= target <= 109
    1 <= nums.length <= 105
    1 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var i = 0; var j = 0
        var sum = 0
        var minLen = Int.MAX_VALUE
        while (j < nums.size) {
            sum += nums[j++]
            while (sum >= target) {
                minLen = min(minLen, j - i)
                sum -= nums[i++]
            }
        }
        return if (minLen == Int.MAX_VALUE) 0 else minLen
    }
}

fun main() {
    val solver = Solution()
    println(solver.minSubArrayLen(4, intArrayOf(1,4,4)))
}