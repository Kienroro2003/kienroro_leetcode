// You are given a 0-indexed integer array nums. There exists an array arr of length nums.length, where arr[i] is the sum of |i - j| over all j such that nums[j] == nums[i] and j != i. If there is no such j, set arr[i] to be 0.
//
// Return the arrayarr.
//
// Example 1:
//
// Input: nums = [1,3,1,1,2]
// Output: [5,0,3,4,0]
// Explanation:
// When i = 0, nums[0] == nums[2] and nums[0] == nums[3]. Therefore, arr[0] = |0 - 2| + |0 - 3| = 5.
// When i = 1, arr[1] = 0 because there is no other index with value 3.
// When i = 2, nums[2] == nums[0] and nums[2] == nums[3]. Therefore, arr[2] = |2 - 0| + |2 - 3| = 3.
// When i = 3, nums[3] == nums[0] and nums[3] == nums[2]. Therefore, arr[3] = |3 - 0| + |3 - 2| = 4.
// When i = 4, arr[4] = 0 because there is no other index with value 2.
//
// Example 2:
//
// Input: nums = [0,5,3]
// Output: [0,0,0]
// Explanation: Since each element in nums is distinct, arr[i] = 0 for all i.
//
// Constraints:
//
// - 1 <= nums.length <= 105
// - 0 <= nums[i] <= 109
//
// Note: This question is the same as 2121: Intervals Between Identical Elements.

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SumOfDistances {
    public static void main(String[] args) {
        SumOfDistances outer = new SumOfDistances();
        Solution solution = outer.new Solution();

        System.out.println(Arrays.toString(solution.distance(
                new int[] { 1, 3, 1, 1, 2 }))); // expected: [5, 0, 3, 4, 0]

        System.out.println(Arrays.toString(solution.distance(
                new int[] { 0, 5, 3 }))); // expected: [0, 0, 0]

        System.out.println(Arrays.toString(solution.distance(
                new int[] { 7 }))); // expected: [0]

        System.out.println(Arrays.toString(solution.distance(
                new int[] { 4, 4, 4, 4 }))); // expected: [6, 4, 4, 6]

        System.out.println(Arrays.toString(solution.distance(
                new int[] { 2, 1, 2, 1, 2 }))); // expected: [6, 2, 4, 2, 6]

        System.out.println(Arrays.toString(solution.distance(
                new int[] { 10, 20, 10, 30, 10, 20 }))); // expected: [6, 4, 4, 0, 6, 4]
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long[] distance(int[] nums) {
            int n = nums.length;
            long[] res = new long[n];
            Map<Integer, long[]> stats = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                long[] state = stats.computeIfAbsent(nums[i], k -> new long[2]);
                res[i] += state[0] * i - state[1];
                state[0]++;
                state[1] += i;
            }

            stats.clear();
            for (int i = nums.length - 1; i >= 0; i--) {
                long[] state = stats.computeIfAbsent(nums[i], k -> new long[2]);
                res[i] += state[1] - state[0] * i;
                state[0]++;
                state[1] += i;
            }
            return res;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
