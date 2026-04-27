// Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
//
// Example 1:
//
// Input: n = 5
// Output: true
// Explanation: The binary representation of 5 is: 101
//
// Example 2:
//
// Input: n = 7
// Output: false
// Explanation: The binary representation of 7 is: 111.
//
// Example 3:
//
// Input: n = 11
// Output: false
// Explanation: The binary representation of 11 is: 1011.
//
// Constraints:
//
// - 1 <= n <= 231 - 1

package com.kienroro.leetcode.editor.en;

public class BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        BinaryNumberWithAlternatingBits outer = new BinaryNumberWithAlternatingBits();
        Solution solution = outer.new Solution();

        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + solution.hasAlternatingBits(i) + " " + Integer.toBinaryString(i));
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasAlternatingBits(int n) {
            n = n ^ (n >> 1);
            return (n & (n + 1)) == 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
