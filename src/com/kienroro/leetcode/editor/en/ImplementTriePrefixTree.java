// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
//
// Implement the Trie class:
//
// - Trie() Initializes the trie object.
// - void insert(String word) Inserts the string word into the trie.
// - boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// - boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
//
// Example 1:
//
// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output
// [null, null, true, false, true, null, true]
//
// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True
//
// Constraints:
//
// - 1 <= word.length, prefix.length <= 2000
// - word and prefix consist only of lowercase English letters.
// - At most 3 * 104 calls in total will be made to insert, search, and startsWith.

package com.kienroro.leetcode.editor.en;

public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        ImplementTriePrefixTree outer = new ImplementTriePrefixTree();
        int passed = 0;
        int total = 0;

        Trie trie1 = outer.new Trie();
        trie1.insert("apple");
        boolean actual1 = trie1.search("apple");
        boolean expected1 = true;
        boolean pass1 = actual1 == expected1;
        total++;
        if (pass1)
            passed++;
        System.out.println("=== CASE 1 ===");
        System.out.println("Input:");
        System.out.println("  operations=[Trie, insert, search]");
        System.out.println("  values=[[], [apple], [apple]]");
        System.out.println("Actual:");
        System.out.println("  " + actual1);
        System.out.println("Expected:");
        System.out.println("  " + expected1);
        System.out.println("Pass:");
        System.out.println("  " + pass1);

        boolean actual2 = trie1.search("app");
        boolean expected2 = false;
        boolean pass2 = actual2 == expected2;
        total++;
        if (pass2)
            passed++;
        System.out.println("=== CASE 2 ===");
        System.out.println("Input:");
        System.out.println("  operations=[search]");
        System.out.println("  values=[[app]]");
        System.out.println("Actual:");
        System.out.println("  " + actual2);
        System.out.println("Expected:");
        System.out.println("  " + expected2);
        System.out.println("Pass:");
        System.out.println("  " + pass2);

        boolean actual3 = trie1.startsWith("app");
        boolean expected3 = true;
        boolean pass3 = actual3 == expected3;
        total++;
        if (pass3)
            passed++;
        System.out.println("=== CASE 3 ===");
        System.out.println("Input:");
        System.out.println("  operations=[startsWith]");
        System.out.println("  values=[[app]]");
        System.out.println("Actual:");
        System.out.println("  " + actual3);
        System.out.println("Expected:");
        System.out.println("  " + expected3);
        System.out.println("Pass:");
        System.out.println("  " + pass3);

        trie1.insert("app");
        boolean actual4 = trie1.search("app");
        boolean expected4 = true;
        boolean pass4 = actual4 == expected4;
        total++;
        if (pass4)
            passed++;
        System.out.println("=== CASE 4 ===");
        System.out.println("Input:");
        System.out.println("  operations=[insert, search]");
        System.out.println("  values=[[app], [app]]");
        System.out.println("Actual:");
        System.out.println("  " + actual4);
        System.out.println("Expected:");
        System.out.println("  " + expected4);
        System.out.println("Pass:");
        System.out.println("  " + pass4);

        Trie trie2 = outer.new Trie();
        trie2.insert("a");
        trie2.insert("ab");
        boolean actual5 = trie2.search("a") && trie2.search("ab") && trie2.startsWith("a") && !trie2.search("abc");
        boolean expected5 = true;
        boolean pass5 = actual5 == expected5;
        total++;
        if (pass5)
            passed++;
        System.out.println("=== CASE 5 ===");
        System.out.println("Input:");
        System.out.println("  operations=[Trie, insert, insert, search, search, startsWith, search]");
        System.out.println("  values=[[], [a], [ab], [a], [ab], [a], [abc]]");
        System.out.println("Actual:");
        System.out.println("  " + actual5);
        System.out.println("Expected:");
        System.out.println("  " + expected5);
        System.out.println("Pass:");
        System.out.println("  " + pass5);

        System.out.println("SUMMARY -> passed: " + passed + "/" + total + ", failed: " + (total - passed));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Trie {
        class TrieNode {
            TrieNode[] children;
            boolean isEndOfWord;

            public TrieNode() {
                this.children = new TrieNode[26];
                this.isEndOfWord = false;
            }
        }

        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();

        }

        public void insert(String word) {
            TrieNode node = this.root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                    node = node.children[c - 'a'];
                    continue;
                }
                node = node.children[c - 'a'];
            }
            node.isEndOfWord = true;

        }

        public boolean search(String word) {
            TrieNode node = this.root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return node.isEndOfWord;

        }

        public boolean startsWith(String prefix) {
            TrieNode node = this.root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return false;
                }
                node = node.children[c - 'a'];
            }
            return true;

        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    // leetcode submit region end(Prohibit modification and deletion)
}
