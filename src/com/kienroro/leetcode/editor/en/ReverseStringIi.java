// Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
//
// If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
//
// Example 1:
//
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
//
// Example 2:
//
// Input: s = "abcd", k = 2
// Output: "bacd"
//
// Constraints:
//
// - 1 <= s.length <= 104
// - s consists of only lowercase English letters.
// - 1 <= k <= 104

package com.kienroro.leetcode.editor.en;

public class ReverseStringIi {
    public static void main(String[] args) {
        ReverseStringIi outer = new ReverseStringIi();
        Solution solution = outer.new Solution();

        // Test case 1: Example 1
        String s1 = "abcdefg";
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.reverseStr(s1, k1)); // Expected: "bacdfeg"

        // Test case 2: Example 2
        String s2 = "abcd";
        int k2 = 2;
        System.out.println("Test Case 2: " + solution.reverseStr(s2, k2)); // Expected: "bacd"

        // Test case 3: String shorter than k
        String s3 = "abc";
        int k3 = 5;
        System.out.println("Test Case 3: " + solution.reverseStr(s3, k3)); // Expected: "cba"

        // Test case 4: k = 1
        String s4 = "abcdef";
        int k4 = 1;
        System.out.println("Test Case 4: " + solution.reverseStr(s4, k4)); // Expected: "abcdef"

        String s5 = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
        int k5 = 39;
        System.out.println("Test Case 5: " + solution.reverseStr(s5, k5)); // Expected:
                                                                           // "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjm"
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] letters = s.toCharArray();
            for (int start = 0; start < letters.length; start += 2 * k) {
                int end = Math.min(start + k - 1, letters.length - 1);
                reverse(letters, start, end);
            }
            return new String(letters);
        }

        private void reverse(char[] letters, int start, int end) {
            while (start < end) {
                swap(letters, start, end);
                start++;
                end--;
            }
        }

        private void swap(char[] letters, int i, int j) {
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
