// Write a function that reverses a string. The input string is given as an array of characters s.
//
// You must do this by modifying the input array in-place with O(1) extra memory.
//
// Example 1:
//
// Input: s = ["h","e","l","l","o"]
// Output: ["o","l","l","e","h"]
//
// Example 2:
//
// Input: s = ["H","a","n","n","a","h"]
// Output: ["h","a","n","n","a","H"]
//
// Constraints:
//
// - 1 <= s.length <= 105
// - s[i] is a printable ascii character.

package com.kienroro.leetcode.editor.en;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString outer = new ReverseString();
        Solution solution = outer.new Solution();

        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s1);
        System.out.println(java.util.Arrays.toString(s1)); // expected: [o, l, l, e, h]

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(s2);
        System.out.println(java.util.Arrays.toString(s2)); // expected: [h, a, n, n, a, H]

        char[] s3 = {'a'};
        solution.reverseString(s3);
        System.out.println(java.util.Arrays.toString(s3)); // expected: [a]

        char[] s4 = {'a', 'b'};
        solution.reverseString(s4);
        System.out.println(java.util.Arrays.toString(s4)); // expected: [b, a]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void reverseString(char[] s) {
            int n = s.length;
            int left = 0;
            int right = n - 1;
            while (left < right) {
                swap(s, left++, right--);
            }
        }

        private void swap(char[] s, int i, int j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
