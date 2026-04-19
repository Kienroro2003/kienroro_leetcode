//Given two strings s and t, return true if they are equal when both are typed 
//into empty text editors. '#' means a backspace character. 
//
// Note that after backspacing an empty text, the text will continue empty. 
//
// 
// Example 1: 
//
// 
//Input: s = "ab#c", t = "ad#c"
//Output: true
//Explanation: Both s and t become "ac".
// 
//
// Example 2: 
//
// 
//Input: s = "ab##", t = "c#d#"
//Output: true
//Explanation: Both s and t become "".
// 
//
// Example 3: 
//
// 
//Input: s = "a#c", t = "b"
//Output: false
//Explanation: s becomes "c" while t becomes "b".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 200 
// s and t only contain lowercase letters and '#' characters. 
// 
//
// 
// Follow up: Can you solve it in O(n) time and O(1) space? 
//
// Related Topics Two Pointers String Stack Simulation 👍 7955 👎 385


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        BackspaceStringCompare outer = new BackspaceStringCompare();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        // Example:
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = solution.twoSum(nums, target);
        // System.out.println(java.util.Arrays.toString(result));
//        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
//        System.out.println(solution.backspaceCompare("a##c", "#a#c"));
//        System.out.println(solution.backspaceCompare("bxj##tw", "bxj###tw"));
        System.out.println(solution.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean backspaceCompare(String s, String t) {
            Deque<Character> stackA = new ArrayDeque<>();
            Deque<Character> stackB = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '#' && !stackA.isEmpty()) {
                    stackA.pop();
                    continue;
                }
                if (c != '#') {
                    stackA.push(c);
                }
            }
            for (char c : t.toCharArray()) {
                if (c == '#' && !stackB.isEmpty()) {
                    stackB.pop();
                    continue;
                }
                if (c != '#') {
                    stackB.push(c);
                }
            }
            if (stackA.size() != stackB.size()) {
                return false;
            }
            while (!stackA.isEmpty() && !stackB.isEmpty()) {
                if (stackA.poll() != stackB.poll()) {
                    return false;
                }
            }
            return true;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}