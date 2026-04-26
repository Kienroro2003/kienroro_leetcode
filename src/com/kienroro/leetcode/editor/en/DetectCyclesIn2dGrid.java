// Given a 2D array of characters grid of size m x n, you need to find if there exists any cycle consisting of the same value in grid.
//
// A cycle is a path of length 4 or more in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it - in one of the four directions (up, down, left, or right), if it has the same value of the current cell.
//
// Also, you cannot move to the cell that you visited in your last move. For example, the cycle (1, 1) -> (1, 2) -> (1, 1) is invalid because from (1, 2) we visited (1, 1) which was the last visited cell.
//
// Return true if any cycle of the same value exists in grid, otherwise, return false.
//
// Example 1:
//
// 1.png
//
// Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
// Output: true
// Explanation:There are two valid cycles shown in different colors in the image below:
// 11.png
//
// Example 2:
//
// 22.png
//
// Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
// Output: true
// Explanation:There is only one valid cycle highlighted in the image below:
// 2.png
//
// Example 3:
//
// 3.png
//
// Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
// Output: false
//
// Constraints:
//
// - m == grid.length
// - n == grid[i].length
// - 1 <= m, n <= 500
// - grid consists only of lowercase English letters.

package com.kienroro.leetcode.editor.en;

public class DetectCyclesIn2dGrid {
    public static void main(String[] args) {
        DetectCyclesIn2dGrid outer = new DetectCyclesIn2dGrid();
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
        public boolean containsCycle(char[][] grid) {
            return false;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
