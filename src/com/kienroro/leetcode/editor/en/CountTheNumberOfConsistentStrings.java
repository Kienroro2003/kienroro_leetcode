// You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistentif all characters in the string appear in the string allowed.
//
// Returnthe number of consistent strings in the arraywords.
//
// Example 1:
//
// Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
// Output: 2
// Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
//
// Example 2:
//
// Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
// Output: 7
// Explanation: All strings are consistent.
//
// Example 3:
//
// Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
// Output: 4
// Explanation: Strings "cc", "acd", "ac", and "d" are consistent.
//
// Constraints:
//
// - 1 <= words.length <= 104
// - 1 <= allowed.length <=26
// - 1 <= words[i].length <= 10
// - The characters in allowed are distinct.
// - words[i] and allowed contain only lowercase English letters.

package com.kienroro.leetcode.editor.en;

public class CountTheNumberOfConsistentStrings {
    public static void main(String[] args) {
        CountTheNumberOfConsistentStrings outer = new CountTheNumberOfConsistentStrings();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        // Example:
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = solution.twoSum(nums, target);
        // System.out.println(java.util.Arrays.toString(result));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countConsistentStrings(String allowed, String[] words) {
            int ans = 0;
            for (String word : words) {
                boolean isAllow = true;
                for (char c : word.toCharArray()) {
                    if (allowed.indexOf(c) == -1) {
                        isAllow = false;
                        break;
                    }
                }
                if (isAllow) {
                    ans++;
                }
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
