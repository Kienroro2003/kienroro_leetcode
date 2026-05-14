// Given two strings s and t, return trueifsis a subsequence oft, orfalseotherwise.
//
// A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
//
// Example 1:
//
// Input: s = "abc", t = "ahbgdc"
// Output: true
//
// Example 2:
//
// Input: s = "axc", t = "ahbgdc"
// Output: false
//
// Constraints:
//
// - 0 <= s.length <= 100
// - 0 <= t.length <= 104
// - s and t consist only of lowercase English letters.
//
// Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

package com.kienroro.leetcode.editor.en;

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence outer = new IsSubsequence();
        Solution solution = outer.new Solution();

        // Test Case 1: Example 1
        System.out.println("Test 1: " + solution.isSubsequence("abc", "ahbgdc") + " (Expected: true)");

        // Test Case 2: Example 2
        System.out.println("Test 2: " + solution.isSubsequence("axc", "ahbgdc") + " (Expected: false)");

        // Test Case 3: s is empty
        System.out.println("Test 3: " + solution.isSubsequence("", "ahbgdc") + " (Expected: true)");

        // Test Case 4: t is empty
        System.out.println("Test 4: " + solution.isSubsequence("abc", "") + " (Expected: false)");

        // Test Case 5: Same strings
        System.out.println("Test 5: " + solution.isSubsequence("abc", "abc") + " (Expected: true)");

        // Test Case 6: Duplicate characters
        System.out.println("Test 6: " + solution.isSubsequence("aaaaaa", "bbaaaa") + " (Expected: false)");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.isEmpty()) {
                return true;
            }
            int pointS = 0;
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(pointS) == t.charAt(i)) {
                    pointS++;
                }
                if (pointS == s.length()) {
                    return true;
                }
            }
            return false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
