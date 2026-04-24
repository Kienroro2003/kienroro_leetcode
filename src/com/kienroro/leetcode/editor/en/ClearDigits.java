//You are given a string s. 
//
// Your task is to remove all digits by doing this operation repeatedly: 
//
// 
// Delete the first digit and the closest non-digit character to its left. 
// 
//
// Return the resulting string after removing all digits. 
//
// Note that the operation cannot be performed on a digit that does not have 
//any non-digit character to its left. 
//
// 
// Example 1: 
//
// 
// Input: s = "abc" 
// 
//
// Output: "abc" 
//
// Explanation: 
//
// There is no digit in the string.
// 
//
// Example 2: 
//
// 
// Input: s = "cb34" 
// 
//
// Output: "" 
//
// Explanation: 
//
// First, we apply the operation on s[2], and s becomes "c4". 
//
// Then we apply the operation on s[1], and s becomes "". 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 100 
// s consists only of lowercase English letters and digits. 
// The input is generated such that it is possible to delete all digits. 
// 
//
// Related Topics String Stack Simulation 👍 704 👎 27


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class ClearDigits {
    public static void main(String[] args) {
        ClearDigits outer = new ClearDigits();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.clearDigits("cb34"));
        System.out.println(solution.clearDigits("abc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String clearDigits(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}