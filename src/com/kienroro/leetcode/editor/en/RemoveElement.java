// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements innumswhich are not equal toval.
//
// Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
//
// - Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
// - Return k.
//
// Custom Judge:
//
// The judge will test your solution with the following code:
//
// int[] nums = [...]; // Input array
// int val = ...; // Value to remove
// int[] expectedNums = [...]; // The expected answer with correct length.
// // It is sorted with no values equaling val.
//
// int k = removeElement(nums, val); // Calls your implementation
//
// assert k == expectedNums.length;
// sort(nums, 0, k); // Sort the first k elements of nums
// for (int i = 0; i < actualLength; i++) {
// assert nums[i] == expectedNums[i];
// }
//
// If all assertions pass, then your solution will be accepted.
//
// Example 1:
//
// Input: nums = [3,2,2,3], val = 3
// Output: 2, nums = [2,2,_,_]
// Explanation: Your function should return k = 2, with the first two elements of nums being 2.
// It does not matter what you leave beyond the returned k (hence they are underscores).
//
// Example 2:
//
// Input: nums = [0,1,2,2,3,0,4,2], val = 2
// Output: 5, nums = [0,1,4,0,3,_,_,_]
// Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
// Note that the five elements can be returned in any order.
// It does not matter what you leave beyond the returned k (hence they are underscores).
//
// Constraints:
//
// - 0 <= nums.length <= 100
// - 0 <= nums[i] <= 50
// - 0 <= val <= 100

package com.kienroro.leetcode.editor.en;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement outer = new RemoveElement();
        Solution solution = outer.new Solution();

        int[] nums1 = { 3, 2, 2, 3 };
        int val1 = 3;
        int k1 = solution.removeElement(nums1, val1);
        System.out.println("k: " + k1 + ", nums: " + java.util.Arrays.toString(nums1)); // expected: k=2

        int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val2 = 2;
        int k2 = solution.removeElement(nums2, val2);
        System.out.println("k: " + k2 + ", nums: " + java.util.Arrays.toString(nums2)); // expected: k=5

        int[] nums3 = {};
        int val3 = 0;
        int k3 = solution.removeElement(nums3, val3);
        System.out.println("k: " + k3 + ", nums: " + java.util.Arrays.toString(nums3)); // expected: k=0

        int[] nums4 = { 1, 1, 1 };
        int val4 = 1;
        int k4 = solution.removeElement(nums4, val4);
        System.out.println("k: " + k4 + ", nums: " + java.util.Arrays.toString(nums4)); // expected: k=0

        int[] nums5 = { 1, 2, 3 };
        int val5 = 4;
        int k5 = solution.removeElement(nums5, val5);
        System.out.println("k: " + k5 + ", nums: " + java.util.Arrays.toString(nums5)); // expected: k=3
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            if (nums.length == 0) {
                return 0;
            }
            int write = 0;
            for (int read = 0; read < nums.length; read++) {
                if (nums[read] != val) {
                    nums[write] = nums[read];
                    write++;
                }
            }
            return write;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
