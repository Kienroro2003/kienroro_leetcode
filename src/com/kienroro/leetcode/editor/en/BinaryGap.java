// Given a positive integer n, find and return the longest distance between any two adjacent1's in the binary representation ofn. If there are no two adjacent1's, return0.
//
// Two 1's are adjacent if there are only 0's separating them (possibly no 0's). The distance between two 1's is the absolute difference between their bit positions. For example, the two 1's in "1001" have a distance of 3.
//
// Example 1:
//
// Input: n = 22
// Output: 2
// Explanation: 22 in binary is "10110".
// The first adjacent pair of 1's is "10110" with a distance of 2.
// The second adjacent pair of 1's is "10110" with a distance of 1.
// The answer is the largest of these two distances, which is 2.
// Note that "10110" is not a valid pair since there is a 1 separating the two 1's underlined.
//
// Example 2:
//
// Input: n = 8
// Output: 0
// Explanation: 8 in binary is "1000".
// There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.
//
// Example 3:
//
// Input: n = 5
// Output: 2
// Explanation: 5 in binary is "101".
//
// Constraints:
//
// - 1 <= n <= 109

package com.kienroro.leetcode.editor.en;

public class BinaryGap {
    public static void main(String[] args) {
        BinaryGap outer = new BinaryGap();
        Solution solution = outer.new Solution();

        for (int i = 0; i < 100; i++) {
            System.out.format("%d %s %d\n", i, Integer.toBinaryString(i), solution.binaryGap(i));
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int binaryGap(int n) {
            if (isPowerTwo(n)) {
                return 0;
            }

            if (isBinaryBit(n)) {
                return 2;
            }
            int largestGap = 0;
            int prev = -1;
            int curr = 0;
            int index = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    if (prev == -1) {
                        prev = index;
                        continue;
                    }
                    curr = index;
                    if (curr - prev > largestGap) {
                        largestGap = curr - prev;
                    }
                    prev = curr;
                }
                n >>>= 1;
                index++;
            }

            return largestGap;
        }

        public boolean isPowerTwo(int num) {
            return (num & (num - 1)) == 0;
        }

        public boolean isBinaryBit(int num) {
            num = num ^ (num >> 1);
            return (num & (num + 1)) == 0;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
