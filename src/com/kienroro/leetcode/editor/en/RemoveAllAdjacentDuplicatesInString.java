//You are given a string s consisting of lowercase English letters. A duplicate 
//removal consists of choosing two adjacent and equal letters and removing them. 
//
// We repeatedly make duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//can be proven that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent 
//and equal, and this is the only possible move.  The result of this move is that 
//the string is "aaca", of which only "aa" is possible, so the final string is 
//"ca".
// 
//
// Example 2: 
//
// 
//Input: s = "azxxzy"
//Output: "ay"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s consists of lowercase English letters. 
// 
//
// Related Topics String Stack 👍 7108 👎 276


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInString outer = new RemoveAllAdjacentDuplicatesInString();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.removeDuplicates("abbaca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}