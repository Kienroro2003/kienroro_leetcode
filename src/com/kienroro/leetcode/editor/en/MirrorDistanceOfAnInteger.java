//You are given an integer n. 
//
// Define its mirror distance as: abs(n - reverse(n)) where reverse(n) is the 
//integer formed by reversing the digits of n. 
//
// Return an integer denoting the mirror distance of n. 
//
// abs(x) denotes the absolute value of x. 
//
// 
// Example 1: 
//
// 
// Input: n = 25 
// 
//
// Output: 27 
//
// Explanation: 
//
// 
// reverse(25) = 52. 
// Thus, the answer is abs(25 - 52) = 27. 
// 
//
// Example 2: 
//
// 
// Input: n = 10 
// 
//
// Output: 9 
//
// Explanation: 
//
// 
// reverse(10) = 01 which is 1. 
// Thus, the answer is abs(10 - 1) = 9. 
// 
//
// Example 3: 
//
// 
// Input: n = 7 
// 
//
// Output: 0 
//
// Explanation: 
//
// 
// reverse(7) = 7. 
// Thus, the answer is abs(7 - 7) = 0. 
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics Math 👍 175 👎 7


package com.kienroro.leetcode.editor.en;

import java.util.Arrays;

public class MirrorDistanceOfAnInteger {
    public static void main(String[] args) {
        MirrorDistanceOfAnInteger outer = new MirrorDistanceOfAnInteger();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.mirrorDistance(10));
        System.out.println(solution.mirrorDistance(25));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mirrorDistance(int n) {
            String numString = "" + n;
            String reversedString = new StringBuilder(numString).reverse().toString();
            int reversedNum = Integer.parseInt(reversedString);
            return Math.abs(reversedNum - n);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}