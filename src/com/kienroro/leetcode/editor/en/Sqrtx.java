// Given a non-negative integer x, return the square root ofxrounded down to the nearest integer. The returned integer should be non-negative as well.
//
// You must not use any built-in exponent function or operator.
//
// - For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
//
// Example 1:
//
// Input: x = 4
// Output: 2
// Explanation: The square root of 4 is 2, so we return 2.
//
// Example 2:
//
// Input: x = 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
//
// Constraints:
//
// - 0 <= x <= 231 - 1

package com.kienroro.leetcode.editor.en;

public class Sqrtx {
    public static void main(String[] args) {
        Sqrtx outer = new Sqrtx();
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
        public int mySqrt(int x) {
            int left = 1;
            int right = x;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (mid > x / mid) {
                    right = mid - 1;
                } else {
                    if (mid + 1 > x / (mid + 1)) {
                        return mid;
                    }
                    left = mid + 1;
                }
            }
            return 0;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
