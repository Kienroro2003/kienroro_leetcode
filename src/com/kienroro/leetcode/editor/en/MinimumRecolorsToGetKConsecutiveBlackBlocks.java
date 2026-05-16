// You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
//
// You are also given an integer k, which is the desired number of consecutive black blocks.
//
// In one operation, you can recolor a white block such that it becomes a black block.
//
// Returnthe minimum number of operations needed such that there is at least one occurrence ofkconsecutive black blocks.
//
// Example 1:
//
// Input: blocks = "WBBWWBBWBW", k = 7
// Output: 3
// Explanation:
// One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
// so that blocks = "BBBBBBBWBW".
// It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
// Therefore, we return 3.
//
// Example 2:
//
// Input: blocks = "WBWBBBW", k = 2
// Output: 0
// Explanation:
// No changes need to be made, since 2 consecutive black blocks already exist.
// Therefore, we return 0.
//
// Constraints:
//
// - n == blocks.length
// - 1 <= n <= 100
// - blocks[i] is either 'W' or 'B'.
// - 1 <= k <= n

package com.kienroro.leetcode.editor.en;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        MinimumRecolorsToGetKConsecutiveBlackBlocks outer = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
        Solution solution = outer.new Solution();

        // System.out.println(solution.minimumRecolors("WBBWWBBWBW", 7)); // expected: 3
        // System.out.println(solution.minimumRecolors("WBWBBBW", 2)); // expected: 0
        // System.out.println(solution.minimumRecolors("W", 1)); // expected: 1
        // System.out.println(solution.minimumRecolors("B", 1)); // expected: 0
        // System.out.println(solution.minimumRecolors("WWWW", 3)); // expected: 3
        // System.out.println(solution.minimumRecolors("BBBB", 4)); // expected: 0
        // System.out.println(solution.minimumRecolors("BWBWB", 3)); // expected: 1
        System.out.println(solution
                .minimumRecolors("BBBBBWWBBWBWBWWWBWBWBBBBWBBBBWBWBWBWBWWBWWBWBWWWWBBWWWWBWWWWBWBBWBBWBBWWW", 29)); // 10
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int whiteCount = 0;
            for (int i = 0; i < k; i++) {
                if (blocks.charAt(i) == 'W') {
                    whiteCount++;
                }
            }

            int minRecolors = whiteCount;
            for (int right = k; right < blocks.length(); right++) {
                int left = right - k;
                if (blocks.charAt(left) == 'W') {
                    whiteCount--;
                }
                if (blocks.charAt(right) == 'W') {
                    whiteCount++;
                }
                minRecolors = Math.min(minRecolors, whiteCount);
            }
            return minRecolors;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
