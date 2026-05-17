// The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
//
// - For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
//
// Given an integer num, return its complement.
//
// Example 1:
//
// Input: num = 5
// Output: 2
// Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
//
// Example 2:
//
// Input: num = 1
// Output: 0
// Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
//
// Constraints:
//
// - 1 <= num < 231
//
// Note: This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/

package com.kienroro.leetcode.editor.en;

public class NumberComplement {
    public static void main(String[] args) {
        NumberComplement outer = new NumberComplement();
        Solution solution = outer.new Solution();

        System.out.println(solution.findComplement(5)); // expected: 2
        System.out.println(solution.findComplement(1)); // expected: 0
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findComplement(int num) {
            int mask = 1;
            while (mask < num) {
                mask = mask << 1 | 1;
            }
            return num ^ mask;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
