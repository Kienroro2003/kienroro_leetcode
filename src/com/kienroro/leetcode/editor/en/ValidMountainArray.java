//Given an array of integers arr, return true if and only if it is a valid 
//mountain array. 
//
// Recall that arr is a mountain array if and only if: 
//
// 
// arr.length >= 3 
// There exists some i with 0 < i < arr.length - 1 such that: 
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
// 
// 
// Example 1: 
// Input: arr = [2,1]
//Output: false
// 
// Example 2: 
// Input: arr = [3,5,5]
//Output: false
// 
// Example 3: 
// Input: arr = [0,3,2,1]
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁴ 
// 
//
// Related Topics Array 👍 3157 👎 211


package com.kienroro.leetcode.editor.en;

public class ValidMountainArray {
    public static void main(String[] args) {
        ValidMountainArray outer = new ValidMountainArray();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        System.out.println(solution.validMountainArray(new int[]{0, 3, 2, 1}));
        System.out.println(solution.validMountainArray(new int[]{8, 7, -1, 0, 3, 2, 1}));
        System.out.println(solution.validMountainArray(new int[]{2, 1}));
        System.out.println(solution.validMountainArray(new int[]{3, 5, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validMountainArray(int[] arr) {
            if (arr.length < 3) {
                return false;
            }
            boolean isMountain = false;
            boolean first = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == arr[i + 1]) {
                    return false;
                }
                if (!isMountain && first && arr[i + 1] < arr[i]) {
                    return false;
                }

                if (!isMountain && arr[i + 1] > arr[i]) {
                    first = false;
                }

                if (!first && !isMountain && arr[i + 1] < arr[i]) {
                    isMountain = true;
                }
                if (!first && isMountain && arr[i] < arr[i + 1]) {
                    return false;
                }
            }
            return isMountain;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}