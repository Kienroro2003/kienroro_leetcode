// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
// Example 1:
//
// Input: s = "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
//
// Example 2:
//
// Input: s = "Mr Ding"
// Output: "rM gniD"
//
// Constraints:
//
// - 1 <= s.length <= 5 * 104
// - s contains printable ASCII characters.
// - s does not contain any leading or trailing spaces.
// - There is at least one word in s.
// - All the words in s are separated by a single space.

package com.kienroro.leetcode.editor.en;

public class ReverseWordsInAStringIii {
    public static void main(String[] args) {
        ReverseWordsInAStringIii outer = new ReverseWordsInAStringIii();
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
        public String reverseWords(String s) {
            String[] words = s.split(" ");
            for (int i = 0; i < words.length; i++) {
                words[i] = reverse(words[i]);
            }
            return String.join(" ", words);

        }

        private String reverse(String word) {
            StringBuilder reversed = new StringBuilder();
            for (int i = word.length() - 1; i >= 0; i--) {
                reversed.append(word.charAt(i));
            }
            return reversed.toString();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
