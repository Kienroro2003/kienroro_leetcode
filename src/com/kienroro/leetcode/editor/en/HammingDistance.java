// The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//
// Given two integers x and y, return the Hamming distance between them.
//
// Example 1:
//
// Input: x = 1, y = 4
// Output: 2
// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
// &uarr;   &uarr;
// The above arrows point to positions where the corresponding bits are different.
//
// Example 2:
//
// Input: x = 3, y = 1
// Output: 1
//
// Constraints:
//
// - 0 <= x, y <= 231 - 1
//
// Note: This question is the same as 2220: Minimum Bit Flips to Convert Number.

package com.kienroro.leetcode.editor.en;

public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance outer = new HammingDistance();
        Solution solution = outer.new Solution();

        System.out.println(solution.hammingDistance(1, 4)); // expected: 2
        System.out.println(solution.hammingDistance(0, 0)); // expected: 0
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int hammingDistance(int x, int y) {
            int distance = x ^ y;
            return countBits(distance);

        }

        public int countBits(int num) {
            int ans = 0;
            while (num != 0) {
                ans++;
                num &= (num - 1);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
