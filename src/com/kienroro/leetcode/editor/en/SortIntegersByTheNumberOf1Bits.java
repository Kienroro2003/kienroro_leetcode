// You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
//
// Return the array after sorting it.
//
// Example 1:
//
// Input: arr = [0,1,2,3,4,5,6,7,8]
// Output: [0,1,2,4,8,3,5,6,7]
// Explantion: [0] is the only integer with 0 bits.
// [1,2,4,8] all have 1 bit.
// [3,5,6] have 2 bits.
// [7] has 3 bits.
// The sorted array by bits is [0,1,2,4,8,3,5,6,7]
//
// Example 2:
//
// Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
// Output: [1,2,4,8,16,32,64,128,256,512,1024]
// Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
//
// Constraints:
//
// - 1 <= arr.length <= 500
// - 0 <= arr[i] <= 104

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SortIntegersByTheNumberOf1Bits {
    public static void main(String[] args) {
        SortIntegersByTheNumberOf1Bits outer = new SortIntegersByTheNumberOf1Bits();
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
        public int[] sortByBits(int[] arr) {
            Map<Integer, List<Integer>> map = new TreeMap<>();
            int[] ans = new int[arr.length];
            for (int num : arr) {
                int countBits = countSetBits(num);
                map.computeIfAbsent(countBits, ArrayList::new).add(num);
            }
            int index = 0;
            for (var list : map.values()) {
                list.sort(null);
                for (int num : list) {
                    ans[index++] = num;
                }
            }
            return ans;

        }

        public int countSetBits(int num) {
            int ans = 0;
            while (num != 0) {
                ans++;
                num = num & (num - 1);
            }
            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
