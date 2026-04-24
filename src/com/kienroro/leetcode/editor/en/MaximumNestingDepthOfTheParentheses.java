//Given a valid parentheses string s, return the nesting depth of s. The 
//nesting depth is the maximum number of nested parentheses. 
//
// 
// Example 1: 
//
// 
// Input: s = "(1+(2*3)+((8)/4))+1" 
// 
//
// Output: 3 
//
// Explanation: 
//
// Digit 8 is inside of 3 nested parentheses in the string. 
//
// Example 2: 
//
// 
// Input: s = "(1)+((2))+(((3)))" 
// 
//
// Output: 3 
//
// Explanation: 
//
// Digit 3 is inside of 3 nested parentheses in the string. 
//
// Example 3: 
//
// 
// Input: s = "()(())((()()))" 
// 
//
// Output: 3 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'. 
// It is guaranteed that parentheses expression s is a VPS. 
// 
//
// Related Topics String Stack 👍 2843 👎 525


package com.kienroro.leetcode.editor.en;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        MaximumNestingDepthOfTheParentheses outer = new MaximumNestingDepthOfTheParentheses();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.maxDepth("()(())((()()))"));
        System.out.println(solution.maxDepth("(1+(2*3)+(((8))/4))+1"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '('){
                currentDepth++;
                if (currentDepth > maxDepth){
                    maxDepth = currentDepth;
                }
            }else if (c == ')'){
                currentDepth--;
            }
        }
        return maxDepth;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}