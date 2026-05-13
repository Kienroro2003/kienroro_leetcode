// In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//
// Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
//
// Example 1:
//
// Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
// Output: true
// Explanation:As 'h' comes before 'l' in this language, then the sequence is sorted.
//
// Example 2:
//
// Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
// Output: false
// Explanation:As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
//
// Example 3:
//
// Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
// Output: false
// Explanation:The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '&empty;', where '&empty;' is defined as the blank character which is less than any other character (More info).
//
// Constraints:
//
// - 1 <= words.length <= 100
// - 1 <= words[i].length <= 20
// - order.length == 26
// - All characters in words[i] and order are English lowercase letters.

package com.kienroro.leetcode.editor.en;

public class VerifyingAnAlienDictionary {
    public static void main(String[] args) {
        VerifyingAnAlienDictionary outer = new VerifyingAnAlienDictionary();
        Solution solution = outer.new Solution();

        // Example 1
        String[] words1 = { "hello", "leetcode" };
        String order1 = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words1, order1)); // expected: true

        // Example 2
        String[] words2 = { "word", "world", "row" };
        String order2 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(solution.isAlienSorted(words2, order2)); // expected: false

        // Example 3
        String[] words3 = { "apple", "app" };
        String order3 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(solution.isAlienSorted(words3, order3)); // expected: false
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            for (int i = 0; i < words.length - 1; i++) {
                String firstWord = words[i];
                String secondWord = words[i + 1];
                if (!compareAlienWord(firstWord, secondWord, order)) {
                    return false;
                }
            }
            return true;
        }

        private boolean compareAlienWord(String first, String second, String order) {
            for (int i = 0; i < Math.min(first.length(), second.length()); i++) {
                if (first.charAt(i) == second.charAt(i)) {
                    continue;
                }
                if (order.indexOf(first.charAt(i)) < order.indexOf(second.charAt(i))) {
                    return true;
                } else {
                    return false;
                }
            }
            return first.length() <= second.length() ? true : false;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
