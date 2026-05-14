// Given a string s, reverse only all the vowels in the string and return it.
//
// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
//
// Example 1:
//
// Input: s = "IceCreAm"
//
// Output: "AceCreIm"
//
// Explanation:
//
// The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".
//
// Example 2:
//
// Input: s = "leetcode"
//
// Output: "leotcede"
//
// Constraints:
//
// - 1 <= s.length <= 3 * 105
// - s consist of printable ASCII characters.

package com.kienroro.leetcode.editor.en;

import java.util.Arrays;

public class ReverseVowelsOfAString {
    public static void main(String[] args) {
        ReverseVowelsOfAString outer = new ReverseVowelsOfAString();
        Solution solution = outer.new Solution();

        // Example 1
        System.out.println("Test 1: " + solution.reverseVowels("IceCreAm") + " (Expected: AceCreIm)");

        // Example 2
        System.out.println("Test 2: " + solution.reverseVowels("leetcode") + " (Expected: leotcede)");

        // Test 3: Only vowels
        System.out.println("Test 3: " + solution.reverseVowels("aeiou") + " (Expected: uoiea)");

        // Test 4: Only consonants
        System.out.println("Test 4: " + solution.reverseVowels("xyz") + " (Expected: xyz)");

        // Test 5: Mixed case and special chars
        System.out.println("Test 5: " + solution.reverseVowels("aA") + " (Expected: Aa)");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            int left = 0;
            int right = s.length() - 1;
            String vowels = "aeiou";
            char[] letters = s.toCharArray();
            while (left < right) {
                while (left < right && vowels.indexOf(Character.toLowerCase(letters[left])) == -1) {
                    left++;
                }
                while (left < right && vowels.indexOf(Character.toLowerCase(letters[right])) == -1) {
                    right--;
                }
                char temp = letters[left];
                letters[left] = letters[right];
                letters[right] = temp;
                left++;
                right--;
            }
            return new String(letters);

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
