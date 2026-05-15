// You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
//
// Return the merged string.
//
// Example 1:
//
// Input: word1 = "abc", word2 = "pqr"
// Output: "apbqcr"
// Explanation: The merged string will be merged as so:
// word1:  a   b   c
// word2:    p   q   r
// merged: a p b q c r
//
// Example 2:
//
// Input: word1 = "ab", word2 = "pqrs"
// Output: "apbqrs"
// Explanation: Notice that as word2 is longer, "rs" is appended to the end.
// word1:  a   b
// word2:    p   q   r   s
// merged: a p b q   r   s
//
// Example 3:
//
// Input: word1 = "abcd", word2 = "pq"
// Output: "apbqcd"
// Explanation: Notice that as word1 is longer, "cd" is appended to the end.
// word1:  a   b   c   d
// word2:    p   q
// merged: a p b q c   d
//
// Constraints:
//
// - 1 <= word1.length, word2.length <= 100
// - word1 and word2 consist of lowercase English letters.

package com.kienroro.leetcode.editor.en;

public class MergeStringsAlternately {
    public static void main(String[] args) {
        MergeStringsAlternately outer = new MergeStringsAlternately();
        Solution solution = outer.new Solution();

        System.out.println(solution.mergeAlternately("abc", "pqr")); // expected: apbqcr
        System.out.println(solution.mergeAlternately("ab", "pqrs")); // expected: apbqrs
        System.out.println(solution.mergeAlternately("abcd", "pq")); // expected: apbqcd
        System.out.println(solution.mergeAlternately("a", "b")); // expected: ab
        System.out.println(solution.mergeAlternately("a", "bcdef")); // expected: abcdef
        System.out.println(solution.mergeAlternately("abcde", "f")); // expected: afbcde
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder merged = new StringBuilder(word1.length() + word2.length());
            int maxLength = Math.max(word1.length(), word2.length());

            for (int i = 0; i < maxLength; i++) {
                if (i < word1.length()) {
                    merged.append(word1.charAt(i));
                }
                if (i < word2.length()) {
                    merged.append(word2.charAt(i));
                }
            }

            return merged.toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
