// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
// Example 1:
//
// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
//
// Example 2:
//
// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.
//
// Constraints:
//
// - 1 <= haystack.length, needle.length <= 104
// - haystack and needle consist of only lowercase English characters.

package com.kienroro.leetcode.editor.en;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString outer = new FindTheIndexOfTheFirstOccurrenceInAString();
        Solution solution = outer.new Solution();

        // Test case 1
        System.out.println(solution.strStr("sadbutsad", "sad")); // Expected: 0

        // Test case 2
        System.out.println(solution.strStr("leetcode", "leeto")); // Expected: -1

        // Test case 3: Needle at the end
        System.out.println(solution.strStr("hello", "ll")); // Expected: 2

        // Test case 4: Needle is same as haystack
        System.out.println(solution.strStr("abc", "abc")); // Expected: 0
        // Test case 5: Needle is longer than haystack
        System.out.println(solution.strStr("aaa", "aaaa")); // Expected: -1
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                boolean isFound = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        isFound = false;
                        break;
                    }
                }
                if (isFound) {
                    return i;
                }
            }
            return -1;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
