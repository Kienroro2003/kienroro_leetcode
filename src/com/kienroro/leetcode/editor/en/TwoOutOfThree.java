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

        // TODO: Setup local test data here.
        // Example:
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = solution.twoSum(nums, target);
        // System.out.println(java.util.Arrays.toString(result));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Set<Integer> set1 = new HashSet<>(Arrays.stream(nums1).boxed().toList());
            Set<Integer> set2 = new HashSet<>(Arrays.stream(nums2).boxed().toList());
            Set<Integer> set3 = new HashSet<>(Arrays.stream(nums3).boxed().toList());
            Set<Integer> ans = new HashSet<>();
            ans.addAll(set1.stream()
                    .filter(set2::contains)
                    .collect(Collectors.toSet()));
            ans.addAll(set1.stream()
                    .filter(set3::contains)
                    .collect(Collectors.toSet()));
            ans.addAll(set2.stream()
                    .filter(set3::contains)
                    .collect(Collectors.toSet()));
            return ans.stream().toList();

        }

    }
    // leetcode submit region end(Prohibit modification and deletion)
}
