// You are given a binary array nums (0-indexed).
//
// We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).
//
// - For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
//
// Return an array of booleansanswerwhereanswer[i]istrueifxiis divisible by5.
//
// Example 1:
//
// Input: nums = [0,1,1]
// Output: [true,false,false]
// Explanation: The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.
// Only the first number is divisible by 5, so answer[0] is true.
//
// Example 2:
//
// Input: nums = [1,1,1]
// Output: [false,false,false]
//
// Constraints:
//
// - 1 <= nums.length <= 105
// - nums[i] is either 0 or 1.

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        BinaryPrefixDivisibleBy5 outer = new BinaryPrefixDivisibleBy5();
        Solution solution = outer.new Solution();

        System.out.println(solution.prefixesDivBy5(new int[] { 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1 }));
        int num = 0;
        while (num <= 100) {
            System.out.format("%d %d %s %s\n", num, 5, Integer.toBinaryString(num), Integer.toBinaryString(5));
            num += 5;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public List<Boolean> prefixesDivBy5(int[] nums) {
            List<Boolean> ans = new ArrayList<>();
            BigInteger curr = BigInteger.ZERO;
            BigInteger five = BigInteger.valueOf(5);
            for (int bit : nums) {
                curr = curr.shiftLeft(1).add(bit == 1 ? BigInteger.ONE : BigInteger.ZERO);
                ans.add(curr.remainder(five).equals(BigInteger.ZERO));
            }
            return ans;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
