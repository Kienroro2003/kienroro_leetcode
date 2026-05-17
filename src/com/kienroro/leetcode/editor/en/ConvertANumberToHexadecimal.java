// Given a 32-bit integer num, return a string representing its hexadecimal representation. For negative integers, two’s complement method is used.
//
// All the letters in the answer string should be lowercase characters, and there should not be any leading zeros in the answer except for the zero itself.
//
// Note:You are not allowed to use any built-in library method to directly solve this problem.
//
// Example 1:
//
// Input: num = 26
// Output: "1a"
//
// Example 2:
//
// Input: num = -1
// Output: "ffffffff"
//
// Constraints:
//
// - -231 <= num <= 231 - 1

package com.kienroro.leetcode.editor.en;

public class ConvertANumberToHexadecimal {
    public static void main(String[] args) {
        ConvertANumberToHexadecimal outer = new ConvertANumberToHexadecimal();
        Solution solution = outer.new Solution();

        System.out.println(solution.toHex(26));
        System.out.println(solution.toHex(-1));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toHex(int num) {
            String ans = "";
            do {
                ans = hexString(num & 15) + ans;
                num >>>= 4;
            } while (num != 0);
            return ans;
        }

        public String hexString(int num) {
            return switch (num) {
                case 10 -> "a";
                case 11 -> "b";
                case 12 -> "c";
                case 13 -> "d";
                case 14 -> "e";
                case 15 -> "f";
                default -> "" + num;
            };
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
