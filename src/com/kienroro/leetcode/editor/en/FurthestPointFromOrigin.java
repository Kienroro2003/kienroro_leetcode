// You are given a string moves of length n consisting only of characters 'L', 'R', and '_'. The string represents your movement on a number line starting from the origin 0.
//
// In the ith move, you can choose one of the following directions:
//
// - move to the left if moves[i] = 'L' or moves[i] = '_'
// - move to the right if moves[i] = 'R' or moves[i] = '_'
//
// Return the distance from the origin of the furthest point you can get to afternmoves.
//
// Example 1:
//
// Input: moves = "L_RL__R"
// Output: 3
// Explanation: The furthest point we can reach from the origin 0 is point -3 through the following sequence of moves "LLRLLLR".
//
// Example 2:
//
// Input: moves = "_R__LL_"
// Output: 5
// Explanation: The furthest point we can reach from the origin 0 is point -5 through the following sequence of moves "LRLLLLL".
//
// Example 3:
//
// Input: moves = "_______"
// Output: 7
// Explanation: The furthest point we can reach from the origin 0 is point 7 through the following sequence of moves "RRRRRRR".
//
// Constraints:
//
// - 1 <= moves.length == n <= 50
// - moves consists only of characters 'L', 'R' and '_'.

package com.kienroro.leetcode.editor.en;

public class FurthestPointFromOrigin {
    public static void main(String[] args) {
        FurthestPointFromOrigin outer = new FurthestPointFromOrigin();
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
        public int furthestDistanceFromOrigin(String moves) {
            int[] countChar = new int[3];
            for (char c : moves.toCharArray()) {
                switch (c) {
                    case 'L' -> countChar[0]++;
                    case 'R' -> countChar[1]++;
                    case '_' -> countChar[2]++;
                }
            }

            return Math.abs(countChar[0] - countChar[1]) + countChar[2];

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
