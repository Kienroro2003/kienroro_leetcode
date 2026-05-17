//Given two strings s and t, return true if t is an anagram of s, and false 
//otherwise. 
//
// 
// Example 1: 
//
// 
// Input: s = "anagram", t = "nagaram" 
// 
//
// Output: true 
//
// Example 2: 
//
// 
// Input: s = "rat", t = "car" 
// 
//
// Output: false 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you 
//adapt your solution to such a case? 
//
// Related Topics Hash Table String Sorting 👍 14365 👎 478


package com.kienroro.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram outer = new ValidAnagram();
        Solution solution = outer.new Solution();

        // Example 1
        System.out.println("Test 1: " + solution.isAnagram("anagram", "nagaram") + " (Expected: true)");

        // Example 2
        System.out.println("Test 2: " + solution.isAnagram("rat", "car") + " (Expected: false)");

        // Test 3: Khác độ dài
        System.out.println("Test 3: " + solution.isAnagram("a", "ab") + " (Expected: false)");

        // Test 4: Giống ký tự nhưng khác số lượng
        System.out.println("Test 4: " + solution.isAnagram("aabb", "abab") + " (Expected: true)");
        System.out.println("Test 5: " + solution.isAnagram("aabb", "aaab") + " (Expected: false)");

        // Test 6: Chuỗi rỗng (nếu ràng buộc cho phép, mặc dù đề bài ghi >= 1)
        // System.out.println("Test 6: " + solution.isAnagram("", "") + " (Expected: true)");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length())
                return false;
            int[] countChar = new int[26];
            for (int i = 0; i < s.length(); i++) {
                countChar[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                if (countChar[t.charAt(i) - 'a']-- == 0)
                    return false;
            }
            for (int i = 0; i < countChar.length; i++) {
                if (countChar[i] != 0)
                    return false;
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}