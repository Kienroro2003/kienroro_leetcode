// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
// Given a string s, return trueif it is a palindrome, orfalseotherwise.
//
// Example 1:
//
// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.
//
// Example 2:
//
// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.
//
// Example 3:
//
// Input: s = " "
// Output: true
// Explanation: s is an empty string "" after removing non-alphanumeric characters.
// Since an empty string reads the same forward and backward, it is a palindrome.
//
// Constraints:
//
// - 1 <= s.length <= 2 * 105
// - s consists only of printable ASCII characters.

package com.kienroro.leetcode.editor.en;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome outer = new ValidPalindrome();
        Solution solution = outer.new Solution();

        // Example 1
        System.out.println("Test 1: " + solution.isPalindrome("A man, a plan, a canal: Panama") + " (Expected: true)");

        // Example 2
        System.out.println("Test 2: " + solution.isPalindrome("race a car") + " (Expected: false)");

        // Example 3
        System.out.println("Test 3: " + solution.isPalindrome(" ") + " (Expected: true)");

        // Test 4: Chuỗi rỗng
        System.out.println("Test 4: " + solution.isPalindrome("") + " (Expected: true)");

        // Test 5: Palindrome chỉ gồm số
        System.out.println("Test 5: " + solution.isPalindrome("12321") + " (Expected: true)");

        // Test 6: Không là Palindrome
        System.out.println("Test 6: " + solution.isPalindrome("hello") + " (Expected: false)");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            int head = 0;
            int tail = s.length() - 1;
            while (head < tail) {
                while (head < tail && !Character.isLetterOrDigit(s.charAt(head))) {
                    head++;
                }
                while (tail > head && !Character.isLetterOrDigit(s.charAt(tail))) {
                    tail--;
                }
                if (s.charAt(head) != s.charAt(tail)) {
                    return false;
                }
                head++;
                tail--;
            }
            return true;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
