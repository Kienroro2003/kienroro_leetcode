// Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
//
// Return any array that satisfies this condition.
//
// Example 1:
//
// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
//
// Example 2:
//
// Input: nums = [0]
// Output: [0]
//
// Constraints:
//
// - 1 <= nums.length <= 5000
// - 0 <= nums[i] <= 5000

package com.kienroro.leetcode.editor.en;

public class SortArrayByParity {
    public static void main(String[] args) {
        SortArrayByParity outer = new SortArrayByParity();
        Solution solution = outer.new Solution();

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[] { 3, 1, 2, 4 })));
        // expected: evens before odds, for example [4, 2, 1, 3]

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[] { 0 })));
        // expected: [0]

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[] { 2, 4, 6 })));
        // expected: [2, 4, 6]

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[] { 1, 3, 5 })));
        // expected: [1, 3, 5]

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[] { 1, 2, 3, 4, 5, 6 })));
        // expected: evens before odds, for example [6, 2, 4, 5, 3, 1]

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[] { 0, 1, 0, 3, 12 })));
        // expected: evens before odds, for example [0, 12, 0, 3, 1]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParity(int[] nums) {
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            while (left < right) {
                while (left < right && nums[left] % 2 == 0) {
                    left++;
                }
                while (left < right && nums[right] % 2 == 1) {
                    right--;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return nums;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
