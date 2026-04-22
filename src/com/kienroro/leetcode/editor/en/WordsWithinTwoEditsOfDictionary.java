// You are given two string arrays, queries and dictionary. All words in each array comprise of lowercase English letters and have the same length.
//
// In one edit you can take a word from queries, and change any letter in it to any other letter. Find all words from queries that, after a maximum of two edits, equal some word from dictionary.
//
// Returna list of all words fromqueries,that match with some word fromdictionaryafter a maximum of two edits. Return the words in the same order they appear in queries.
//
// Example 1:
//
// Input: queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
// Output: ["word","note","wood"]
// Explanation:
// - Changing the 'r' in "word" to 'o' allows it to equal the dictionary word "wood".
// - Changing the 'n' to 'j' and the 't' to 'k' in "note" changes it to "joke".
// - It would take more than 2 edits for "ants" to equal a dictionary word.
// - "wood" can remain unchanged (0 edits) and match the corresponding dictionary word.
// Thus, we return ["word","note","wood"].
//
// Example 2:
//
// Input: queries = ["yes"], dictionary = ["not"]
// Output: []
// Explanation:
// Applying any two edits to "yes" cannot make it equal to "not". Thus, we return an empty array.
//
// Constraints:
//
// - 1 <= queries.length, dictionary.length <= 100
// - n == queries[i].length == dictionary[j].length
// - 1 <= n <= 100
// - All queries[i] and dictionary[j] are composed of lowercase English letters.

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary {
    public static void main(String[] args) {
        WordsWithinTwoEditsOfDictionary outer = new WordsWithinTwoEditsOfDictionary();
        Solution solution = outer.new Solution();

        System.out.println(solution.twoEditWords(
                new String[] { "word", "note", "ants", "wood" },
                new String[] { "wood", "joke", "moat" })); // expected: [word, note, wood]

        System.out.println(solution.twoEditWords(
                new String[] { "yes" },
                new String[] { "not" })); // expected: []

        System.out.println(solution.twoEditWords(
                new String[] { "abc", "abd", "xyz" },
                new String[] { "abc" })); // expected: [abc, abd]

        System.out.println(solution.twoEditWords(
                new String[] { "a", "b", "c" },
                new String[] { "b" })); // expected: [a, b, c]

        System.out.println(solution.twoEditWords(
                new String[] { "abzz", "xbcy", "zzzz" },
                new String[] { "abcd" })); // expected: [abzz, xbcy]

        System.out.println(solution.twoEditWords(
                new String[] { "word", "word", "ants" },
                new String[] { "wood" })); // expected: [word, word]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            List<String> res = new ArrayList<>();
            for (String query : queries) {
                for (String word : dictionary) {
                    int maxEdit = 2;
                    for (int i = 0; i < query.length(); i++) {
                        if (query.charAt(i) != word.charAt(i)) {
                            maxEdit--;
                        }
                    }
                    if (maxEdit >= 0) {
                        res.add(query);
                        break;
                    }
                }
            }

            return res;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
