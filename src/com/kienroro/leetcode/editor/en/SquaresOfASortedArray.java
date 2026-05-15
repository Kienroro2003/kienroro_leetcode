// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
//
// Example 1:
//
// Input: nums = [-4,-1,0,3,10]
// Output: [0,1,9,16,100]
// Explanation: After squaring, the array becomes [16,1,0,9,100].
// After sorting, it becomes [0,1,9,16,100].
//
// Example 2:
//
// Input: nums = [-7,-3,2,3,11]
// Output: [4,9,9,49,121]
//
// Constraints:
//
// - 1 <= nums.length <=104
// - -104 <= nums[i] <= 104
// - nums is sorted in non-decreasing order.
//
// Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

package com.kienroro.leetcode.editor.en;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        SquaresOfASortedArray outer = new SquaresOfASortedArray();
        Solution solution = outer.new Solution();

        // Test case 1
        int[] nums1 = { -4, -1, 0, 3, 10 };
        int[] result1 = solution.sortedSquares(nums1);
        System.out.println("Test Case 1: " + java.util.Arrays.toString(result1));
        // Expected: [0, 1, 9, 16, 100]

        // Test case 2
        int[] nums2 = { -7, -3, 2, 3, 11 };
        int[] result2 = solution.sortedSquares(nums2);
        System.out.println("Test Case 2: " + java.util.Arrays.toString(result2));
        // Expected: [4, 9, 9, 49, 121]

        // Test case 3: All negative
        int[] nums3 = { -5, -3, -1 };
        int[] result3 = solution.sortedSquares(nums3);
        System.out.println("Test Case 3: " + java.util.Arrays.toString(result3));
        // Expected: [1, 9, 25]

        // Test case 4: Single element
        int[] nums4 = { -2 };
        int[] result4 = solution.sortedSquares(nums4);
        System.out.println("Test Case 4: " + java.util.Arrays.toString(result4));
        // Expected: [4]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            int left = 0;
            int right = n - 1;
            int write = n - 1;

            while (left <= right) {
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    ans[write] = nums[left] * nums[left];
                    left++;
                } else {
                    ans[write] = nums[right] * nums[right];
                    right--;
                }
                write--;
            }

            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
