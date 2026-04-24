// Given two binary strings a and b, return their sum as a binary string.
//
// Example 1:
//
// Input: a = "11", b = "1"
// Output: "100"
//
// Example 2:
//
// Input: a = "1010", b = "1011"
// Output: "10101"
//
// Constraints:
//
// - 1 <= a.length, b.length <= 104
// - a and b consist only of '0' or '1' characters.
// - Each string does not contain leading zeros except for the zero itself.

package com.kienroro.leetcode.editor.en;

public class AddBinary {
    public static void main(String[] args) {
        AddBinary outer = new AddBinary();
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
        public String addBinary(String a, String b) {
            java.math.BigInteger numA = new java.math.BigInteger(a, 2);
            java.math.BigInteger numB = new java.math.BigInteger(b, 2);
            return numA.add(numB).toString(2);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
