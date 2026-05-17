// Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.
//
// If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.
//
// Note that the word should be built from left to right with each additional character being added to the end of a previous word.
//
// Example 1:
//
// Input: words = ["w","wo","wor","worl","world"]
// Output: "world"
// Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
//
// Example 2:
//
// Input: words = ["a","banana","app","appl","ap","apply","apple"]
// Output: "apple"
// Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
//
// Constraints:
//
// - 1 <= words.length <= 1000
// - 1 <= words[i].length <= 30
// - words[i] consists of lowercase English letters.

package com.kienroro.leetcode.editor.en;

public class LongestWordInDictionary {
    public static void main(String[] args) {
        LongestWordInDictionary outer = new LongestWordInDictionary();
        Solution solution = outer.new Solution();

        int passed = 0;
        int total = 0;

        String[] words1 = { "w", "wo", "wor", "worl", "world" };
        String actual1 = solution.longestWord(words1);
        String expected1 = "world";
        boolean pass1 = java.util.Objects.equals(actual1, expected1);
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

        String[] words2 = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        String actual2 = solution.longestWord(words2);
        String expected2 = "apple";
        boolean pass2 = java.util.Objects.equals(actual2, expected2);
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

        String[] words3 = { "abc", "bc", "ab", "qwe" };
        String actual3 = solution.longestWord(words3);
        String expected3 = "";
        boolean pass3 = java.util.Objects.equals(actual3, expected3);
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

        String[] words4 = { "b", "br", "bre", "brea", "break", "a", "ap", "app", "appl", "apple" };
        String actual4 = solution.longestWord(words4);
        String expected4 = "apple";
        boolean pass4 = java.util.Objects.equals(actual4, expected4);
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

        String[] words5 = { "z", "za", "zar", "zara", "x", "xy", "xyz" };
        String actual5 = solution.longestWord(words5);
        String expected5 = "zara";
        boolean pass5 = java.util.Objects.equals(actual5, expected5);
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
            TrieNode[] children = new TrieNode[26];
            boolean isEndOfWord = false;
        }

        public void insert(TrieNode root, String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isEndOfWord = true;
        }

        public boolean search(TrieNode root, String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null || !current.children[index].isEndOfWord) {
                    return false;
                }
                current = current.children[index];
            }
            return true;
        }

        public boolean isBetter(String ans, String word) {
            if (word.length() > ans.length()) {
                return true;
            } else if (word.length() == ans.length()) {
                return ans.compareTo(word) > 0;
            }
            return false;
        }

        public String longestWord(String[] words) {
            TrieNode root = new TrieNode();
            String ans = "";
            for (var word : words) {
                insert(root, word);
            }
            for (var word : words) {
                if (search(root, word) && isBetter(ans, word)) {
                    ans = word;
                }
            }
            return ans;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
