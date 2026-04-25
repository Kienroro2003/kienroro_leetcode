// Given an integer n, return true if it is a power of two. Otherwise, return false.
//
// An integer n is a power of two, if there exists an integer x such that n == 2x.
//
// Example 1:
//
// Input: n = 1
// Output: true
// Explanation:20 = 1
//
// Example 2:
//
// Input: n = 16
// Output: true
// Explanation:24 = 16
//
// Example 3:
//
// Input: n = 3
// Output: false
//
// Constraints:
//
// - -231 <= n <= 231 - 1
//
// Follow up: Could you solve it without loops/recursion?

package com.kienroro.leetcode.editor.en;

public class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo outer = new PowerOfTwo();
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
        public boolean isPowerOfTwo(int n) {
            return n > 0 && (n & (n - 1)) == 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
