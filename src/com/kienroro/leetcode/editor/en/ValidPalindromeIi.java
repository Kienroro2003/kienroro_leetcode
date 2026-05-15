// Given a string s, return true if thescan be palindrome after deleting at most one character from it.
//
// Example 1:
//
// Input: s = "aba"
// Output: true
//
// Example 2:
//
// Input: s = "abca"
// Output: true
// Explanation: You could delete the character 'c'.
//
// Example 3:
//
// Input: s = "abc"
// Output: false
//
// Constraints:
//
// - 1 <= s.length <= 105
// - s consists of lowercase English letters.

package com.kienroro.leetcode.editor.en;

public class ValidPalindromeIi {
    public static void main(String[] args) {
        ValidPalindromeIi outer = new ValidPalindromeIi();
        Solution solution = outer.new Solution();

        System.out.println(solution.validPalindrome("aba")); // expected: true
        System.out.println(solution.validPalindrome("abca")); // expected: true
        System.out.println(solution.validPalindrome("abc")); // expected: false
        System.out.println(solution.validPalindrome("a")); // expected: true
        System.out.println(solution.validPalindrome("deeee")); // expected: true
        System.out.println(solution.validPalindrome("cbbcc")); // expected: true
        System.out.println(solution.validPalindrome("ebcbbececabbacecbbcbe")); // expected: true
        System.out.println(solution.validPalindrome(
                "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        // exptected:
        // true
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
                }

                left++;
                right--;
            }

            return true;
        }

        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
