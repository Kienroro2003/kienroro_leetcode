// You are given an integer n and an integer start.
//
// Define an array nums where nums[i] = start + 2 * i (0-indexed) and n == nums.length.
//
// Return the bitwise XOR of all elements of nums.
//
// Example 1:
//
// Input: n = 5, start = 0
// Output: 8
// Explanation: Array nums is equal to [0, 2, 4, 6, 8] where (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8.
// Where "^" corresponds to bitwise XOR operator.
//
// Example 2:
//
// Input: n = 4, start = 3
// Output: 8
// Explanation: Array nums is equal to [3, 5, 7, 9] where (3 ^ 5 ^ 7 ^ 9) = 8.
//
// Constraints:
//
// - 1 <= n <= 1000
// - 0 <= start <= 1000
// - n == nums.length

package com.kienroro.leetcode.editor.en;

public class XorOperationInAnArray {
    public static void main(String[] args) {
        XorOperationInAnArray outer = new XorOperationInAnArray();
        Solution solution = outer.new Solution();

        System.out.println(solution.xorOperation(5, 5));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int xorOperation(int n, int start) {
            int e = start & 1;
            int s = start >> 1;
            int k = xor(s + n - 1) ^ xor(s - 1);
            return (k << 1) | (n & e);

        }

        public int xor(int x) {
            if (x % 4 == 0) {
                return x;
            }
            if (x % 4 == 1) {
                return 1;
            }
            if (x % 4 == 2) {
                return x + 1;
            }
            return 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
