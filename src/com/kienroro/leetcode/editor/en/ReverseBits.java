// Reverse bits of a given 32 bits signed integer.
//
// Example 1:
//
// Input: n = 43261596
//
// Output: 964176192
//
// Explanation:
//
// Integer
// Binary
//
// 43261596
// 00000010100101000001111010011100
//
// 964176192
// 00111001011110000010100101000000
//
// Example 2:
//
// Input: n = 2147483644
//
// Output: 1073741822
//
// Explanation:
//
// Integer
// Binary
//
// 2147483644
// 01111111111111111111111111111100
//
// 1073741822
// 00111111111111111111111111111110
//
// Constraints:
//
// - 0 <= n <= 231 - 2
// - n is even.
//
// Follow up: If this function is called many times, how would you optimize it?

package com.kienroro.leetcode.editor.en;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits outer = new ReverseBits();
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
        public int reverseBits(int n) {

            return convertBinaryStringToInt(convertIntToReverseBinaryString(n));
        }

        public String convertIntToReverseBinaryString(int num) {
            if (num == 0) {
                return "0";
            }

            StringBuilder ans = new StringBuilder();
            while (num > 0) {
                ans.append("" + num % 2);
                num /= 2;
            }
            return ans.toString() + "0".repeat(32 - ans.length());
        }

        public int convertBinaryStringToInt(String binaryString) {
            int current = 0;
            for (char bit : binaryString.toCharArray()) {
                current = current << 1 | (bit - '0');
            }
            return current;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
