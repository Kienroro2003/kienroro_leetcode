// Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.
//
// Substrings that occur multiple times are counted the number of times they occur.
//
// Example 1:
//
// Input: s = "00110011"
// Output: 6
// Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
// Notice that some of these substrings repeat and are counted the number of times they occur.
// Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
//
// Example 2:
//
// Input: s = "10101"
// Output: 4
// Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
//
// Constraints:
//
// - 1 <= s.length <= 105
// - s[i] is either '0' or '1'.

package com.kienroro.leetcode.editor.en;

import java.util.Arrays;

public class CountBinarySubstrings {
    public static void main(String[] args) {
        CountBinarySubstrings outer = new CountBinarySubstrings();
        Solution solution = outer.new Solution();

        System.out.println(solution.countBinarySubstrings("00110011")); // expected: 6
        System.out.println(solution.countBinarySubstrings("10101")); // expected: 4
        System.out.println(solution.countBinarySubstrings("0")); // expected: 0
        System.out.println(solution.countBinarySubstrings("01")); // expected: 1
        System.out.println(solution.countBinarySubstrings("00110")); // expected: 3
        System.out.println(solution.countBinarySubstrings("000111")); // expected: 3
        System.out.println(solution.countBinarySubstrings("0000")); // expected: 0
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBinarySubstrings(String s) {
            int[] group = new int[s.length()];
            int write = 0;
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(write) == s.charAt(i)) {
                    group[j]++;
                } else {
                    write = i;
                    group[++j]++;
                }
            }
            int ans = 0;
            for (int i = 0; i < group.length - 1; i++) {
                ans += Math.min(group[i], group[i + 1]);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
