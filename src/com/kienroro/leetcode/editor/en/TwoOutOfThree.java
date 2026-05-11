// Given three integer arrays nums1, nums2, and nums3, return a distinct array containing all the values that are present in at least two out of the three arrays. You may return the values in any order.
//
// Example 1:
//
// Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
// Output: [3,2]
// Explanation: The values that are present in at least two arrays are:
// - 3, in all three arrays.
// - 2, in nums1 and nums2.
//
// Example 2:
//
// Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
// Output: [2,3,1]
// Explanation: The values that are present in at least two arrays are:
// - 2, in nums2 and nums3.
// - 3, in nums1 and nums2.
// - 1, in nums1 and nums3.
//
// Example 3:
//
// Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
// Output: []
// Explanation: No value is present in at least two arrays.
//
// Constraints:
//
// - 1 <= nums1.length, nums2.length, nums3.length <= 100
// - 1 <= nums1[i], nums2[j], nums3[k] <= 100

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoOutOfThree {
    public static void main(String[] args) {
        TwoOutOfThree outer = new TwoOutOfThree();
        Solution solution = outer.new Solution();

        System.out.println(solution.twoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3})); // expected: [2, 3]
        System.out.println(solution.twoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2})); // expected: [1, 2, 3]
        System.out.println(solution.twoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5})); // expected: []
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

            List<Integer> ans = new ArrayList<>();
            int[] mask = new int[101];
            for (int num : nums1) {
                mask[num] |= 1;
            }
            for (int num : nums2) {
                mask[num] |= 2;
            }
            for (int num : nums3) {
                mask[num] |= 4;
            }
            for (int i = 1; i < mask.length; i++) {
                int m = mask[i];
                if ((m & (m - 1)) != 0) {
                    ans.add(i);
                }
            }
            return ans;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)
}
