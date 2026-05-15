// You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.
//
// Given the integer n, return the number of complete rows of the staircase you will build.
//
// Example 1:
//
// arrangecoins1-grid.jpg
//
// Input: n = 5
// Output: 2
// Explanation: Because the 3rd row is incomplete, we return 2.
//
// Example 2:
//
// arrangecoins2-grid.jpg
//
// Input: n = 8
// Output: 3
// Explanation: Because the 4th row is incomplete, we return 3.
//
// Constraints:
//
// - 1 <= n <= 231 - 1

package com.kienroro.leetcode.editor.en;

public class ArrangingCoins {
    public static void main(String[] args) {
        ArrangingCoins outer = new ArrangingCoins();
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
        public int arrangeCoins(int n) {
            int ans = 0;
            while (n > 0) {
                ans++;
                n -= ans;
            }
            return n == 0 ? ans : ans - 1;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
