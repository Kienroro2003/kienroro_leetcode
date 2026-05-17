// Given an integer array nums and an integer k, return true if there are two distinct indicesiandjin the array such thatnums[i] == nums[j]andabs(i - j) <= k.
//
// Example 1:
//
// Input: nums = [1,2,3,1], k = 3
// Output: true
//
// Example 2:
//
// Input: nums = [1,0,1,1], k = 1
// Output: true
//
// Example 3:
//
// Input: nums = [1,2,3,1,2,3], k = 2
// Output: false
//
// Constraints:
//
// - 1 <= nums.length <= 105
// - -109 <= nums[i] <= 109
// - 0 <= k <= 105

package com.kienroro.leetcode.editor.en;

public class ContainsDuplicateIi {
    public static void main(String[] args) {
        ContainsDuplicateIi outer = new ContainsDuplicateIi();
        Solution solution = outer.new Solution();

        System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 3)); // expected: true
        System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 0, 1, 1 }, 1)); // expected: true
        System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1, 2, 3 }, 2)); // expected: false
        System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 2, 3, 1 }, 2)); // expected: false
        System.out.println(solution.containsNearbyDuplicate(new int[] { 1, 1 }, 0)); // expected: false
        System.out.println(solution.containsNearbyDuplicate(new int[] { 99, 99 }, 1)); // expected: true
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            java.util.HashSet<Integer> set = new java.util.HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return true;
                }
                set.add(nums[i]);
                if (set.size() > k) {
                    set.remove(nums[i - k]);
                }
            }
            return false;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
