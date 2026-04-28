// You are given a 0-indexed string array words.
//
// Two strings are similar if they consist of the same characters.
//
// - For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
// - However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.
//
// Return the number of pairs(i, j)such that0 <= i < j <= word.length - 1and the two stringswords[i]andwords[j]are similar.
//
// Example 1:
//
// Input: words = ["aba","aabb","abcd","bac","aabc"]
// Output: 2
// Explanation: There are 2 pairs that satisfy the conditions:
// - i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
// - i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'.
//
// Example 2:
//
// Input: words = ["aabb","ab","ba"]
// Output: 3
// Explanation: There are 3 pairs that satisfy the conditions:
// - i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
// - i = 0 and j = 2 : both words[0] and words[2] only consist of characters 'a' and 'b'.
// - i = 1 and j = 2 : both words[1] and words[2] only consist of characters 'a' and 'b'.
//
// Example 3:
//
// Input: words = ["nba","cba","dba"]
// Output: 0
// Explanation: Since there does not exist any pair that satisfies the conditions, we return 0.
//
// Constraints:
//
// - 1 <= words.length <= 100
// - 1 <= words[i].length <= 100
// - words[i] consist of only lowercase English letters.

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountPairsOfSimilarStrings {
    public static void main(String[] args) {
        CountPairsOfSimilarStrings outer = new CountPairsOfSimilarStrings();
        Solution solution = outer.new Solution();

        System.out.println(new HashSet<>(List.of(1, 2, 3)).equals(new HashSet<>(List.of(3, 2, 1))));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int similarPairs(String[] words) {
            List<Set<Character>> uniqueCharSets = new ArrayList<>();
            for (String word : words) {
                uniqueCharSets.add(toSetChar(word));
            }
            int count = 0;
            for (int i = 0; i < uniqueCharSets.size(); i++) {
                for (int j = i + 1; j < uniqueCharSets.size(); j++) {
                    if (uniqueCharSets.get(i).equals(uniqueCharSets.get(j))) {
                        count++;
                    }
                }
            }
            return count;
        }

        public Set<Character> toSetChar(String s) {
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                set.add(c);
            }
            return set;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
