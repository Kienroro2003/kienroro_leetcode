// You are given a positive integer n.
//
// Let even denote the number of even indices in the binary representation of n with value 1.
//
// Let odd denote the number of odd indices in the binary representation of n with value 1.
//
// Note that bits are indexed from right to left in the binary representation of a number.
//
// Return the array [even, odd].
//
// Example 1:
//
// Input: n = 50
//
// Output: [1,2]
//
// Explanation:
//
// The binary representation of 50 is 110010.
//
// It contains 1 on indices 1, 4, and 5.
//
// Example 2:
//
// Input: n = 2
//
// Output: [0,1]
//
// Explanation:
//
// The binary representation of 2 is 10.
//
// It contains 1 only on index 1.
//
// Constraints:
//
// - 1 <= n <= 1000

package com.kienroro.leetcode.editor.en;

public class NumberOfEvenAndOddBits {
    public static void main(String[] args) {
        NumberOfEvenAndOddBits outer = new NumberOfEvenAndOddBits();
        Solution solution = outer.new Solution();

        System.out.println(java.util.Arrays.toString(solution.evenOddBit(50))); // expected: [1, 2]
        System.out.println(java.util.Arrays.toString(solution.evenOddBit(1))); // expected: [1, 0]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] evenOddBit(int n) {
            int[] ans = new int[] { 0, 0 };
            int index = 0;
            while (n != 0) {
                boolean isOne = (n & 1) == 1;
                if (isOne) {
                    ans[index % 2]++;
                }
                n >>>= 1;
                index++;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
