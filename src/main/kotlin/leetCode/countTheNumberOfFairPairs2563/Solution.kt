package org.example.leetCode.countTheNumberOfFairPairs2563

/*
Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

A pair (i, j) is fair if:

    0 <= i < j < n, and
    lower <= nums[i] + nums[j] <= upper



Example 1:

Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
Output: 6
Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).

Example 2:

Input: nums = [1,7,9,2,5], lower = 11, upper = 11
Output: 1
Explanation: There is a single fair pair: (2,3).



Constraints:

    1 <= nums.length <= 105
    nums.length == n
    -109 <= nums[i] <= 109
    -109 <= lower <= upper <= 109


 */

class Solution {
    fun countFairPairs(nums: IntArray, lower: Int, upper: Int): Long {
        nums.sort()
        var counter = 0L
        val n = nums.size
        var leftBorder = n - 1
        var rightBorder = n - 1
        for (i in 0 until n - 1) {
            while (leftBorder > i && nums[i] + nums[leftBorder] > upper) {
                leftBorder--
            }
            while (rightBorder > i && nums[i] + nums[rightBorder] >= lower) {
                rightBorder--
            }
            val start = maxOf(rightBorder, i)
            if (leftBorder > start) {
                counter += (leftBorder - start).toLong()
            }
        }
        return counter
    }
}

fun main() {
    val solver = Solution()
    println(solver.countFairPairs(intArrayOf(0, 1, 7, 4, 4, 5), 3, 6))
}