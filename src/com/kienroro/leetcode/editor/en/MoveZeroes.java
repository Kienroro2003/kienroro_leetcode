// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
// Note that you must do this in-place without making a copy of the array.
//
// Example 1:
//
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
//
// Example 2:
//
// Input: nums = [0]
// Output: [0]
//
// Constraints:
//
// - 1 <= nums.length <= 104
// - -231 <= nums[i] <= 231 - 1
//
// Follow up: Could you minimize the total number of operations done?

package com.kienroro.leetcode.editor.en;

public class MoveZeroes {
    public static void main(String[] args) {
        MoveZeroes outer = new MoveZeroes();
        Solution solution = outer.new Solution();

        int[] nums1 = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(nums1);
        System.out.println(java.util.Arrays.toString(nums1)); // expected: [1, 3, 12, 0, 0]

        int[] nums2 = { 0 };
        solution.moveZeroes(nums2);
        System.out.println(java.util.Arrays.toString(nums2)); // expected: [0]

        int[] nums3 = { 1, 2, 3 };
        solution.moveZeroes(nums3);
        System.out.println(java.util.Arrays.toString(nums3)); // expected: [1, 2, 3]

        int[] nums4 = { 0, 0, 1 };
        solution.moveZeroes(nums4);
        System.out.println(java.util.Arrays.toString(nums4)); // expected: [1, 0, 0]

        int[] nums5 = { 4, 0, 5, 0, 6 };
        solution.moveZeroes(nums5);
        System.out.println(java.util.Arrays.toString(nums5)); // expected: [4, 5, 6, 0, 0]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int snowballSize = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    snowballSize++;
                } else {
                    nums[i - snowballSize] = nums[i];
                }
            }
            for (int i = 0; i < snowballSize; i++) {
                nums[nums.length - i - 1] = 0;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
