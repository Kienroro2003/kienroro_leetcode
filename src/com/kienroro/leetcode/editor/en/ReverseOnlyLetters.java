// Given a string s, reverse the string according to the following rules:
//
// - All the characters that are not English letters remain in the same position.
// - All the English letters (lowercase or uppercase) should be reversed.
//
// Return safter reversing it.
//
// Example 1:
//
// Input: s = "ab-cd"
// Output: "dc-ba"
//
// Example 2:
//
// Input: s = "a-bC-dEf-ghIj"
// Output: "j-Ih-gfE-dCba"
//
// Example 3:
//
// Input: s = "Test1ng-Leet=code-Q!"
// Output: "Qedo1ct-eeLg=ntse-T!"
//
// Constraints:
//
// - 1 <= s.length <= 100
// - s consists of characters with ASCII values in the range [33, 122].
// - s does not contain '\"' or '\\'.

package com.kienroro.leetcode.editor.en;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        ReverseOnlyLetters outer = new ReverseOnlyLetters();
        Solution solution = outer.new Solution();

        System.out.println(solution.reverseOnlyLetters("ab-cd")); // expected: dc-ba
        System.out.println(solution.reverseOnlyLetters("a-bC-dEf-ghIj")); // expected: j-Ih-gfE-dCba
        System.out.println(solution.reverseOnlyLetters("Test1ng-Leet=code-Q!")); // expected: Qedo1ct-eeLg=ntse-T!
        System.out.println(solution.reverseOnlyLetters("7_28]")); // expected: 7_28]
        System.out.println(solution.reverseOnlyLetters("z<*zj")); // expected: j<*zz
        System.out.println(solution.reverseOnlyLetters("A-bC-dE")); // expected: E-dC-bA
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseOnlyLetters(String s) {
            int left = 0;
            int right = s.length() - 1;
            char[] letters = s.toCharArray();
            while (left < right) {
                while (left < right && !Character.isLetter(s.charAt(left))) {
                    left++;
                }
                while (left < right && !Character.isLetter(s.charAt(right))) {
                    right--;
                }
                swap(letters, left, right);
                left++;
                right--;
            }
            return new String(letters);
        }

        private void swap(char[] letters, int i, int j) {
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
