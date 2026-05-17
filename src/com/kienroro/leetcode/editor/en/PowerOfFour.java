// Given an integer n, return true if it is a power of four. Otherwise, return false.
//
// An integer n is a power of four, if there exists an integer x such that n == 4x.
//
// Example 1:
//
// Input: n = 16
// Output: true
//
// Example 2:
//
// Input: n = 5
// Output: false
//
// Example 3:
//
// Input: n = 1
// Output: true
//
// Constraints:
//
// - -231 <= n <= 231 - 1
//
// Follow up: Could you solve it without loops/recursion?

package com.kienroro.leetcode.editor.en;

public class PowerOfFour {
    public static void main(String[] args) {
        PowerOfFour outer = new PowerOfFour();
        Solution solution = outer.new Solution();

        System.out.println(solution.isPowerOfFour(16));
        System.out.println(solution.isPowerOfFour(4));
        System.out.println(solution.isPowerOfFour(2));
        System.out.println(solution.isPowerOfFour(-16));
        System.out.println(solution.isPowerOfFour(-4));
        System.out.println(solution.isPowerOfFour(-2));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPowerOfFour(int n) {
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0 && n % 3 == 1;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
