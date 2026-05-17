// You are given an integer array deck where deck[i] represents the number written on the ith card.
//
// Partition the cards into one or more groups such that:
//
// - Each group has exactly x cards where x > 1, and
// - All the cards in one group have the same integer written on them.
//
// Return trueif such partition is possible, orfalseotherwise.
//
// Example 1:
//
// Input: deck = [1,2,3,4,4,3,2,1]
// Output: true
// Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
//
// Example 2:
//
// Input: deck = [1,1,1,2,2,2,3,3]
// Output: false
// Explanation: No possible partition.
//
// Constraints:
//
// - 1 <= deck.length <= 104
// - 0 <= deck[i] < 104

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XOfAKindInADeckOfCards {
    public static void main(String[] args) {
        XOfAKindInADeckOfCards outer = new XOfAKindInADeckOfCards();
        Solution solution = outer.new Solution();

        int[] deck1 = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println(solution.hasGroupsSizeX(deck1)); // expected: true

        int[] deck2 = {1, 1, 1, 2, 2, 2, 3, 3};
        System.out.println(solution.hasGroupsSizeX(deck2)); // expected: false

        int[] deck3 = {1};
        System.out.println(solution.hasGroupsSizeX(deck3)); // expected: false

        int[] deck4 = {1, 1, 2, 2, 2, 2};
        System.out.println(solution.hasGroupsSizeX(deck4)); // expected: true
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            int[] count = new int[10000];
            for (int card : deck) {
                count[card]++;
            }

            int g = -1;
            for (int c : count) {
                if (c > 0) {
                    if (g == -1) {
                        g = c;
                    } else {
                        g = findGCD(g, c);
                    }
                }
            }
            return g >= 2;
        }

        private int findGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
