// You are given a 0-indexed integer array nums and an integer k.
//
// Return an integer that denotes the sum of elements innumswhose corresponding indices have exactlykset bits in their binary representation.
//
// The set bits in an integer are the 1's present when it is written in binary.
//
// - For example, the binary representation of 21 is 10101, which has 3 set bits.
//
// Example 1:
//
// Input: nums = [5,10,1,5,2], k = 1
// Output: 13
// Explanation: The binary representation of the indices are:
// 0 = 0002
// 1 = 0012
// 2 = 0102
// 3 = 0112
// 4 = 1002Indices 1, 2, and 4 have k = 1 set bits in their binary representation.
// Hence, the answer is nums[1] + nums[2] + nums[4] = 13.
//
// Example 2:
//
// Input: nums = [4,3,2,1], k = 2
// Output: 1
// Explanation: The binary representation of the indices are:
// 0 = 002
// 1 = 012
// 2 = 102
// 3 = 112Only index 3 has k = 2 set bits in its binary representation.
// Hence, the answer is nums[3] = 1.
//
// Constraints:
//
// - 1 <= nums.length <= 1000
// - 1 <= nums[i] <= 105
// - 0 <= k <= 10

package com.kienroro.leetcode.editor.en;

import java.util.List;

public class SumOfValuesAtIndicesWithKSetBits {
    public static void main(String[] args) {
        SumOfValuesAtIndicesWithKSetBits outer = new SumOfValuesAtIndicesWithKSetBits();
        Solution solution = outer.new Solution();

        for (int i = 0; i < 1001; i++) {
            if ((i & (i - 1)) == 0) {
                System.out.println(i + " " + Integer.toBinaryString(i));
                /*
                 * 0
                 * 1
                 * 2
                 * 4 100
                 * 8 1000
                 * 16 10000
                 * 32 100000
                 * 64 1000000
                 * 128 10000000
                 * 256 100000000
                 * 512 1000000000
                 */
            }
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.size(); i++) {
                int remaining = k;
                int temp = i;
                while (temp != 0) {
                    boolean isOne = (temp & 1) == 1;
                    if (isOne) {
                        remaining--;
                    }
                    temp >>>= 1;
                }
                if (remaining == 0) {
                    ans += nums.get(i);
                }
            }
            return ans;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
