// A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
//
// Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
//
// Example 1:
//
// Input: s = "YazaAay"
// Output: "aAa"
// Explanation:"aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
// "aAa" is the longest nice substring.
//
// Example 2:
//
// Input: s = "Bb"
// Output: "Bb"
// Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
//
// Example 3:
//
// Input: s = "c"
// Output: ""
// Explanation: There are no nice substrings.
//
// Constraints:
//
// - 1 <= s.length <= 100
// - s consists of uppercase and lowercase English letters.

package com.kienroro.leetcode.editor.en;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        LongestNiceSubstring outer = new LongestNiceSubstring();
        Solution solution = outer.new Solution();

        System.out.println(solution.longestNiceSubstring("YazaAay"));

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestNiceSubstring(String s) {
            if (s.length() <= 1) {
                return "";
            }
            int n = s.length();
            int start = 0;
            int maxLength = 0;
            for (int l = 0; l < n; l++) {
                int lowerMask = 0;
                int uppoerMask = 0;
                for (int r = l; r < n; r++) {
                    char letter = s.charAt(r);
                    if (letter >= 'a' && letter <= 'z') {
                        lowerMask |= 1 << (letter - 'a');
                    }
                    if (letter >= 'A' && letter <= 'Z') {
                        uppoerMask |= 1 << (letter - 'A');
                    }
                    if (uppoerMask == lowerMask) {
                        int len = r - l + 1;
                        if (len > maxLength) {
                            start = l;
                            maxLength = len;
                        }
                    }
                }
            }

            return s.substring(start, start + maxLength);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
