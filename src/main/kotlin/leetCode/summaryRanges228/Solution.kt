package org.example.leetCode.summaryRanges228

/*
You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

    "a->b" if a != b
    "a" if a == b



Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"



Constraints:

    0 <= nums.length <= 20
    -231 <= nums[i] <= 231 - 1
    All the values of nums are unique.
    nums is sorted in ascending order.


 */

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        var i = 0; var j = 1
        var leftBorder: Int
        var rightBorder: Int
        val answer = mutableListOf<String>()
        while (j <= nums.size) {
            leftBorder = nums[i]
            rightBorder = nums[j - 1]
            when {
                j == nums.size -> {
                    val rangeToInsert = if (leftBorder == rightBorder) {
                        "$leftBorder"
                    } else {
                        "$leftBorder->$rightBorder"
                    }
                    answer.add(rangeToInsert)
                    break
                }
                nums[j] != nums[j - 1] + 1 -> {
                    val rangeToInsert = if (leftBorder == rightBorder) {
                        "$leftBorder"
                    } else {
                        "$leftBorder->$rightBorder"
                    }
                    answer.add(rangeToInsert)
                    i = j
                    j = i + 1
                }
                else -> j++
            }
        }
        return answer
    }
}

fun main() {
    val solver = Solution()
    println(solver.summaryRanges(intArrayOf(0,1,2,4,5,7)))
}