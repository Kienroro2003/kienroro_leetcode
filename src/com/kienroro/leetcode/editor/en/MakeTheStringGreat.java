//Given a string s of lower and upper case English letters. 
//
// A good string is a string which doesn't have two adjacent characters s[i] 
//and s[i + 1] where: 
//
// 
// 0 <= i <= s.length - 2 
// s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-
//case or vice-versa. 
// 
//
// To make the string good, you can choose two adjacent characters that make 
//the string bad and remove them. You can keep doing this until the string becomes 
//good. 
//
// Return the string after making it good. The answer is guaranteed to be 
//unique under the given constraints. 
//
// Notice that an empty string is also good. 
//
// 
// Example 1: 
//
// 
//Input: s = "leEeetcode"
//Output: "leetcode"
//Explanation: In the first step, either you choose i = 1 or i = 2, both will 
//result "leEeetcode" to be reduced to "leetcode".
// 
//
// Example 2: 
//
// 
//Input: s = "abBAcC"
//Output: ""
//Explanation: We have many possible scenarios, and all lead to the same answer.
// For example:
//"abBAcC" --> "aAcC" --> "cC" --> ""
//"abBAcC" --> "abBA" --> "aA" --> ""
// 
//
// Example 3: 
//
// 
//Input: s = "s"
//Output: "s"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s contains only lower and upper case English letters. 
// 
//
// Related Topics String Stack 👍 3231 👎 189


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        MakeTheStringGreat outer = new MakeTheStringGreat();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.makeGood("leEeetcode"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String makeGood(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
                    stack.pop();
                } else {
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