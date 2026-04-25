// Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
//
// Example 1:
//
// Input: n = 11
//
// Output: 3
//
// Explanation:
//
// The input binary string 1011 has a total of three set bits.
//
// Example 2:
//
// Input: n = 128
//
// Output: 1
//
// Explanation:
//
// The input binary string 10000000 has a total of one set bit.
//
// Example 3:
//
// Input: n = 2147483645
//
// Output: 30
//
// Explanation:
//
// The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
//
// Constraints:
//
// - 1 <= n <= 231 - 1
//
// Follow up: If this function is called many times, how would you optimize it?

package com.kienroro.leetcode.editor.en;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1Bits outer = new NumberOf1Bits();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        // Example:
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = solution.twoSum(nums, target);
        // System.out.println(java.util.Arrays.toString(result));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingWeight(int n) {
            int ans = 0;
            while (n != 0) {
                ans++;
                n = n & (n - 1);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
