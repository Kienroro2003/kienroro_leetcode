// Given a string s and a character c that occurs in s, return an array of integersanswerwhereanswer.length == s.lengthandanswer[i]is the distance from indexito the closest occurrence of charactercins.
//
// The distance between two indices i and j is abs(i - j), where abs is the absolute value function.
//
// Example 1:
//
// Input: s = "loveleetcode", c = "e"
// Output: [3,2,1,0,1,0,0,1,2,2,1,0]
// Explanation: The character 'e' appears at indices 3, 5, 6, and 11 (0-indexed).
// The closest occurrence of 'e' for index 0 is at index 3, so the distance is abs(0 - 3) = 3.
// The closest occurrence of 'e' for index 1 is at index 3, so the distance is abs(1 - 3) = 2.
// For index 4, there is a tie between the 'e' at index 3 and the 'e' at index 5, but the distance is still the same: abs(4 - 3) == abs(4 - 5) = 1.
// The closest occurrence of 'e' for index 8 is at index 6, so the distance is abs(8 - 6) = 2.
//
// Example 2:
//
// Input: s = "aaab", c = "b"
// Output: [3,2,1,0]
//
// Constraints:
//
// - 1 <= s.length <= 104
// - s[i] and c are lowercase English letters.
// - It is guaranteed that c occurs at least once in s.

package com.kienroro.leetcode.editor.en;

public class ShortestDistanceToACharacter {
    public static void main(String[] args) {
        ShortestDistanceToACharacter outer = new ShortestDistanceToACharacter();
        Solution solution = outer.new Solution();

        System.out.println(java.util.Arrays.toString(solution.shortestToChar("loveleetcode", 'e')));
        // expected: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

        System.out.println(java.util.Arrays.toString(solution.shortestToChar("aaab", 'b')));
        // expected: [3, 2, 1, 0]

        System.out.println(java.util.Arrays.toString(solution.shortestToChar("a", 'a')));
        // expected: [0]

        System.out.println(java.util.Arrays.toString(solution.shortestToChar("baaa", 'b')));
        // expected: [0, 1, 2, 3]

        System.out.println(java.util.Arrays.toString(solution.shortestToChar("abbb", 'a')));
        // expected: [0, 1, 2, 3]

        System.out.println(java.util.Arrays.toString(solution.shortestToChar("ababa", 'b')));
        // expected: [1, 0, 1, 0, 1]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] shortestToChar(String s, char c) {
            int[] ans = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                int best = Integer.MAX_VALUE;
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == c) {
                        best = Math.min(best, Math.abs(i - j));
                    }
                }
                ans[i] = best;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
