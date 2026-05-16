// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
// You must implement a solution with a linear runtime complexity and use only constant extra space.
//
// Example 1:
//
// Input: nums = [2,2,1]
//
// Output: 1
//
// Example 2:
//
// Input: nums = [4,1,2,1,2]
//
// Output: 4
//
// Example 3:
//
// Input: nums = [1]
//
// Output: 1
//
// Constraints:
//
// - 1 <= nums.length <= 3 * 104
// - -3 * 104 <= nums[i] <= 3 * 104
// - Each element in the array appears twice except for one element which appears only once.

package com.kienroro.leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber outer = new SingleNumber();
        Solution solution = outer.new Solution();

        System.out.println(solution.singleNumber(new int[] { 4, 1, 2, 1, 2 })); // expected: 4
        System.out.println(solution.singleNumber(new int[] { 1 })); // expected: 1
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
