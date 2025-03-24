package leetCode.findKthBitInNthBinaryString1545

import kotlin.math.pow
/*
Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.



Example 1:

Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".
Example 2:

Input: n = 4, k = 11
Output: "1"
Explanation: S4 is "011100110110001".
The 11th bit is "1".


Constraints:

1 <= n <= 20
1 <= k <= 2n - 1
 */
class Solution {
    fun findKthBit(n: Int, k: Int): Char {
        val index = k - 1
        val lenOfString = 2.0.pow(n).toInt() - 1
        val halfOfLen = lenOfString / 2
        return when {
            n == 1 -> return '0'
            index in 0 until halfOfLen  -> {
                findKthBit(n - 1, k)
            }
            index == halfOfLen -> {
                '1'
            }
            else -> {
                val mirroredK = lenOfString - k + 1
                if (findKthBit(n - 1, mirroredK) == '0') '1' else '0'
            }
        }
    }
}