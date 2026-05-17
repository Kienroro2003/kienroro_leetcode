// Given a positive integer num, return true if num is a perfect square or false otherwise.
//
// A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.
//
// You must not use any built-in library function, such as sqrt.
//
// Example 1:
//
// Input: num = 16
// Output: true
// Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
//
// Example 2:
//
// Input: num = 14
// Output: false
// Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
//
// Constraints:
//
// - 1 <= num <= 231 - 1

package com.kienroro.leetcode.editor.en;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        ValidPerfectSquare outer = new ValidPerfectSquare();
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
        public boolean isPerfectSquare(int num) {
            int left = 1, right = num;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long square = (long) mid * mid;
                if (square == num) {
                    return true;
                } else if (square < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
