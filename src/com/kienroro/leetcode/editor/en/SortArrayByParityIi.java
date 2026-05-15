// Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
//
// Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
//
// Return any answer array that satisfies this condition.
//
// Example 1:
//
// Input: nums = [4,2,5,7]
// Output: [4,5,2,7]
// Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//
// Example 2:
//
// Input: nums = [2,3]
// Output: [2,3]
//
// Constraints:
//
// - 2 <= nums.length <= 2 * 104
// - nums.length is even.
// - Half of the integers in nums are even.
// - 0 <= nums[i] <= 1000
//
// Follow Up: Could you solve it in-place?

package com.kienroro.leetcode.editor.en;

public class SortArrayByParityIi {
    public static void main(String[] args) {
        SortArrayByParityIi outer = new SortArrayByParityIi();
        Solution solution = outer.new Solution();

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParityII(new int[] { 4, 2, 5, 7 })));
        // expected: even indexes have even values, odd indexes have odd values

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParityII(new int[] { 2, 3 })));
        // expected: [2, 3]

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParityII(new int[] { 3, 2 })));
        // expected: [2, 3]

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParityII(new int[] { 1, 4, 3, 2 })));
        // expected: even indexes have even values, odd indexes have odd values

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParityII(new int[] { 0, 1, 2, 3, 4, 5 })));
        // expected: [0, 1, 2, 3, 4, 5]

        System.out.println(java.util.Arrays.toString(solution.sortArrayByParityII(new int[] { 5, 4, 3, 2, 1, 0 })));
        // expected: even indexes have even values, odd indexes have odd values
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArrayByParityII(int[] nums) {
            int evenIndex = 0;
            int oddIndex = 1;

            while (evenIndex < nums.length && oddIndex < nums.length) {
                while (evenIndex < nums.length && nums[evenIndex] % 2 == 0) {
                    evenIndex += 2;
                }
                while (oddIndex < nums.length && nums[oddIndex] % 2 == 1) {
                    oddIndex += 2;
                }

                if (evenIndex < nums.length && oddIndex < nums.length) {
                    int temp = nums[evenIndex];
                    nums[evenIndex] = nums[oddIndex];
                    nums[oddIndex] = temp;
                }
            }

            return nums;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
