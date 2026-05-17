// You are given a 0-indexed string array words.
//
// Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:
//
// - isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix and a suffix of str2, and false otherwise.
//
// For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.
//
// Return an integer denoting the number of index pairs(i, j)such thati < j, andisPrefixAndSuffix(words[i], words[j])istrue.
//
// Example 1:
//
// Input: words = ["a","aba","ababa","aa"]
// Output: 4
// Explanation: In this example, the counted index pairs are:
// i = 0 and j = 1 because isPrefixAndSuffix("a", "aba") is true.
// i = 0 and j = 2 because isPrefixAndSuffix("a", "ababa") is true.
// i = 0 and j = 3 because isPrefixAndSuffix("a", "aa") is true.
// i = 1 and j = 2 because isPrefixAndSuffix("aba", "ababa") is true.
// Therefore, the answer is 4.
//
// Example 2:
//
// Input: words = ["pa","papa","ma","mama"]
// Output: 2
// Explanation: In this example, the counted index pairs are:
// i = 0 and j = 1 because isPrefixAndSuffix("pa", "papa") is true.
// i = 2 and j = 3 because isPrefixAndSuffix("ma", "mama") is true.
// Therefore, the answer is 2.
//
// Example 3:
//
// Input: words = ["abab","ab"]
// Output: 0
// Explanation:In this example, the only valid index pair is i = 0 and j = 1, and isPrefixAndSuffix("abab", "ab") is false.
// Therefore, the answer is 0.
//
// Constraints:
//
// - 1 <= words.length <= 50
// - 1 <= words[i].length <= 10
// - words[i] consists only of lowercase English letters.

package com.kienroro.leetcode.editor.en;

public class CountPrefixAndSuffixPairsI {
    public static void main(String[] args) {
        CountPrefixAndSuffixPairsI outer = new CountPrefixAndSuffixPairsI();
        Solution solution = outer.new Solution();

        int passed = 0;
        int total = 0;

        String[] words1 = { "a", "aba", "ababa", "aa" };
        int actual1 = solution.countPrefixSuffixPairs(words1);
        int expected1 = 4;
        boolean pass1 = actual1 == expected1;
        total++;
        if (pass1)
            passed++;
        System.out.println("=== CASE 1 ===");
        System.out.println("Input:");
        System.out.println("  words=" + java.util.Arrays.toString(words1));
        System.out.println("Actual:");
        System.out.println("  " + actual1);
        System.out.println("Expected:");
        System.out.println("  " + expected1);
        System.out.println("Pass:");
        System.out.println("  " + pass1);

        String[] words2 = { "pa", "papa", "ma", "mama" };
        int actual2 = solution.countPrefixSuffixPairs(words2);
        int expected2 = 2;
        boolean pass2 = actual2 == expected2;
        total++;
        if (pass2)
            passed++;
        System.out.println("=== CASE 2 ===");
        System.out.println("Input:");
        System.out.println("  words=" + java.util.Arrays.toString(words2));
        System.out.println("Actual:");
        System.out.println("  " + actual2);
        System.out.println("Expected:");
        System.out.println("  " + expected2);
        System.out.println("Pass:");
        System.out.println("  " + pass2);

        String[] words3 = { "abab", "ab" };
        int actual3 = solution.countPrefixSuffixPairs(words3);
        int expected3 = 0;
        boolean pass3 = actual3 == expected3;
        total++;
        if (pass3)
            passed++;
        System.out.println("=== CASE 3 ===");
        System.out.println("Input:");
        System.out.println("  words=" + java.util.Arrays.toString(words3));
        System.out.println("Actual:");
        System.out.println("  " + actual3);
        System.out.println("Expected:");
        System.out.println("  " + expected3);
        System.out.println("Pass:");
        System.out.println("  " + pass3);

        String[] words4 = { "a", "a", "a" };
        int actual4 = solution.countPrefixSuffixPairs(words4);
        int expected4 = 3;
        boolean pass4 = actual4 == expected4;
        total++;
        if (pass4)
            passed++;
        System.out.println("=== CASE 4 ===");
        System.out.println("Input:");
        System.out.println("  words=" + java.util.Arrays.toString(words4));
        System.out.println("Actual:");
        System.out.println("  " + actual4);
        System.out.println("Expected:");
        System.out.println("  " + expected4);
        System.out.println("Pass:");
        System.out.println("  " + pass4);

        String[] words5 = { "abc", "abcabc", "bc", "abc" };
        int actual5 = solution.countPrefixSuffixPairs(words5);
        int expected5 = 2;
        boolean pass5 = actual5 == expected5;
        total++;
        if (pass5)
            passed++;
        System.out.println("=== CASE 5 ===");
        System.out.println("Input:");
        System.out.println("  words=" + java.util.Arrays.toString(words5));
        System.out.println("Actual:");
        System.out.println("  " + actual5);
        System.out.println("Expected:");
        System.out.println("  " + expected5);
        System.out.println("Pass:");
        System.out.println("  " + pass5);

        System.out.println("SUMMARY -> passed: " + passed + "/" + total + ", failed: " + (total - passed));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class TrieNode {
            TrieNode[] children = new TrieNode[26 * 26];
            int wordCount;
        }

        public int countPrefixSuffixPairs(String[] words) {
            TrieNode root = new TrieNode();
            int pairs = 0;

            for (String word : words) {
                TrieNode node = root;

                for (int i = 0; i < word.length() && node != null; i++) {
                    int key = getKey(word.charAt(i), word.charAt(word.length() - 1 - i));
                    node = node.children[key];
                    if (node != null) {
                        pairs += node.wordCount;
                    }
                }

                insert(root, word);
            }

            return pairs;
        }

        private void insert(TrieNode root, String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int key = getKey(word.charAt(i), word.charAt(word.length() - 1 - i));
                if (node.children[key] == null) {
                    node.children[key] = new TrieNode();
                }
                node = node.children[key];
            }
            node.wordCount++;
        }

        private int getKey(char prefixChar, char suffixChar) {
            return (prefixChar - 'a') * 26 + (suffixChar - 'a');
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
