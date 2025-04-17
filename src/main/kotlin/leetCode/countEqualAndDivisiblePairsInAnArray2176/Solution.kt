package org.example.leetCode.countEqualAndDivisiblePairsInAnArray2176

/*
Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) where 0 <= i < j < n, such that nums[i] == nums[j] and (i * j) is divisible by k.



Example 1:

Input: nums = [3,1,2,2,2,1,3], k = 2
Output: 4
Explanation:
There are 4 pairs that meet all the requirements:
- nums[0] == nums[6], and 0 * 6 == 0, which is divisible by 2.
- nums[2] == nums[3], and 2 * 3 == 6, which is divisible by 2.
- nums[2] == nums[4], and 2 * 4 == 8, which is divisible by 2.
- nums[3] == nums[4], and 3 * 4 == 12, which is divisible by 2.

Example 2:

Input: nums = [1,2,3,4], k = 1
Output: 0
Explanation: Since no value in nums is repeated, there are no pairs (i,j) that meet all the requirements.



Constraints:

    1 <= nums.length <= 100
    1 <= nums[i], k <= 100

 */


class Solution {
    private fun getDivisors(k: Int): IntArray {
        val tmp = IntArray(k)
        var tc = 0
        for (d in 1..k) {
            if (k % d == 0) {
                tmp[tc++] = d
            }
        }
        return tmp.copyOf(tc)
    }

    private fun precomputeGcd(n: Int, k: Int): IntArray {
        fun gcd(a: Int, b: Int): Int {
            var x = a
            var y = b
            while (y != 0) {
                val t = x % y
                x = y
                y = t
            }
            return if (x < 0) -x else x
        }
        return IntArray(n) { i -> gcd(i, k) }
    }

    fun countPairs(nums: IntArray, k: Int): Int {
        val n = nums.size
        val divisors = getDivisors(k)
        val dcount = divisors.size
        val divIndex = IntArray(k + 1) { -1 }
        for (i in 0 until dcount) {
            divIndex[divisors[i]] = i
        }
        val gcds = precomputeGcd(n, k)
        val freq = Array(101) { IntArray(dcount) }
        var total = 0
        for (pos in 0 until n) {
            val v = nums[pos]
            val g = gcds[pos]
            val gi = divIndex[g]
            for (j in 0 until dcount) {
                if (g.toLong() * divisors[j] % k == 0L) {
                    total += freq[v][j]
                }
            }
            freq[v][gi]++
        }
        return total
    }
}

fun main() {
    val solver = Solution()
    println(solver.countPairs(intArrayOf(3, 1, 2, 2, 2, 1, 3), 2))
    println(solver.countPairs(intArrayOf(1, 2, 3, 4), 1))
}
