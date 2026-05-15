// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// An input string is valid if:
//
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
// 3. Every close bracket has a corresponding open bracket of the same type.
//
// Example 1:
//
// Input: s = "()"
//
// Output: true
//
// Example 2:
//
// Input: s = "()[]{}"
//
// Output: true
//
// Example 3:
//
// Input: s = "(]"
//
// Output: false
//
// Example 4:
//
// Input: s = "([])"
//
// Output: true
//
// Example 5:
//
// Input: s = "([)]"
//
// Output: false
//
// Constraints:
//
// - 1 <= s.length <= 104
// - s consists of parentheses only '()[]{}'.

package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses outer = new ValidParentheses();
        Solution solution = outer.new Solution();

        String[] tests = {
                "()",
                "()[]{}",
                "(]",
                "([])",
                "([)]",
                "{[]}",
                "(",
                "]",
                "(){}}{"
        };

        boolean[] expected = {
                true,
                true,
                false,
                true,
                false,
                true,
                false,
                false,
                false
        };

        for (int i = 0; i < tests.length; i++) {
            try {
                boolean actual = solution.isValid(tests[i]);
                System.out.printf("s = %-8s -> actual: %-5s expected: %s%n", "\"" + tests[i] + "\"", actual,
                        expected[i]);
            } catch (Exception e) {
                System.out.printf("s = %-8s -> threw: %-20s expected: %s%n", "\"" + tests[i] + "\"",
                        e.getClass().getSimpleName(), expected[i]);
            }
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            String openingBrackets = "([{";
            String closingBrackets = ")]}";
            for (char c : s.toCharArray()) {
                if (openingBrackets.indexOf(c) != -1) {
                    stack.push(c);
                    continue;
                }
                if (closingBrackets.indexOf(c) != -1) {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if (openingBrackets.indexOf(top) != closingBrackets.indexOf(c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
