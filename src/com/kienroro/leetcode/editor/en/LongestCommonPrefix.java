// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
// Input: strs = ["flower","flow","flight"]
// Output: "fl"
//
// Example 2:
//
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
// Constraints:
//
// - 1 <= strs.length <= 200
// - 0 <= strs[i].length <= 200
// - strs[i] consists of only lowercase English letters if it is non-empty.

package com.kienroro.leetcode.editor.en;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix outer = new LongestCommonPrefix();
        Solution solution = outer.new Solution();

        int passed = 0;
        int total = 0;

        String[] strs1 = { "flower", "flow", "flight" };
        String actual1 = solution.longestCommonPrefix(strs1);
        String expected1 = "fl";
        boolean pass1 = java.util.Objects.equals(actual1, expected1);
        total++;
        if (pass1)
            passed++;
        System.out.println("=== CASE 1 ===");
        System.out.println("Input:");
        System.out.println("  strs=" + java.util.Arrays.toString(strs1));
        System.out.println("Actual:");
        System.out.println("  " + actual1);
        System.out.println("Expected:");
        System.out.println("  " + expected1);
        System.out.println("Pass:");
        System.out.println("  " + pass1);

        String[] strs2 = { "dog", "racecar", "car" };
        String actual2 = solution.longestCommonPrefix(strs2);
        String expected2 = "";
        boolean pass2 = java.util.Objects.equals(actual2, expected2);
        total++;
        if (pass2)
            passed++;
        System.out.println("=== CASE 2 ===");
        System.out.println("Input:");
        System.out.println("  strs=" + java.util.Arrays.toString(strs2));
        System.out.println("Actual:");
        System.out.println("  " + actual2);
        System.out.println("Expected:");
        System.out.println("  " + expected2);
        System.out.println("Pass:");
        System.out.println("  " + pass2);

        String[] strs3 = { "", "b" };
        String actual3 = solution.longestCommonPrefix(strs3);
        String expected3 = "";
        boolean pass3 = java.util.Objects.equals(actual3, expected3);
        total++;
        if (pass3)
            passed++;
        System.out.println("=== CASE 3 ===");
        System.out.println("Input:");
        System.out.println("  strs=" + java.util.Arrays.toString(strs3));
        System.out.println("Actual:");
        System.out.println("  " + actual3);
        System.out.println("Expected:");
        System.out.println("  " + expected3);
        System.out.println("Pass:");
        System.out.println("  " + pass3);

        String[] strs4 = { "alone" };
        String actual4 = solution.longestCommonPrefix(strs4);
        String expected4 = "alone";
        boolean pass4 = java.util.Objects.equals(actual4, expected4);
        total++;
        if (pass4)
            passed++;
        System.out.println("=== CASE 4 ===");
        System.out.println("Input:");
        System.out.println("  strs=" + java.util.Arrays.toString(strs4));
        System.out.println("Actual:");
        System.out.println("  " + actual4);
        System.out.println("Expected:");
        System.out.println("  " + expected4);
        System.out.println("Pass:");
        System.out.println("  " + pass4);

        String[] strs5 = { "same", "same", "same" };
        String actual5 = solution.longestCommonPrefix(strs5);
        String expected5 = "same";
        boolean pass5 = java.util.Objects.equals(actual5, expected5);
        total++;
        if (pass5)
            passed++;
        System.out.println("=== CASE 5 ===");
        System.out.println("Input:");
        System.out.println("  strs=" + java.util.Arrays.toString(strs5));
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
        class Trie {
            class TrieNode {
                TrieNode[] children = new TrieNode[26];
                boolean isEndOfWord;
            }

            TrieNode root;

            public Trie() {
                this.root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode node = root;
                for (char c : word.toCharArray()) {
                    int index = c - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new TrieNode();
                    }
                    node = node.children[index];
                }
                node.isEndOfWord = true;
            }

        }

        public String longestCommonPrefix(String[] strs) {
            int n = strs.length;
            StringBuilder ansBuilder = new StringBuilder(strs[0]);
            int end = ansBuilder.length();
            for (int i = 1; i < n; i++) {
                if (strs[i].isEmpty()) {
                    return "";
                }
                StringBuilder builder = new StringBuilder(strs[i]);
                for (int j = 0; j < ansBuilder.length() && j < builder.length(); j++) {
                    if (ansBuilder.charAt(j) != builder.charAt(j)) {
                        end = j;
                        break;
                    }
                    end = j + 1;

                }
                ansBuilder.delete(end, ansBuilder.length());

            }
            return ansBuilder.toString();

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
