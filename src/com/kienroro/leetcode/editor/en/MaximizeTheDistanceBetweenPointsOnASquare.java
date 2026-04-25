// You are given an integer side, representing the edge length of a square with corners at (0, 0), (0, side), (side, 0), and (side, side) on a Cartesian plane.
//
// You are also given a positive integer k and a 2D integer array points, where points[i] = [xi, yi] represents the coordinate of a point lying on the boundary of the square.
//
// You need to select k elements among points such that the minimum Manhattan distance between any two points is maximized.
//
// Return the maximum possible minimum Manhattan distance between the selected k points.
//
// The Manhattan Distance between two cells (xi, yi) and (xj, yj) is |xi - xj| + |yi - yj|.
//
// Example 1:
//
// Input: side = 2, points = [[0,2],[2,0],[2,2],[0,0]], k = 4
//
// Output: 2
//
// Explanation:
//
// 4080_example0_revised.png
//
// Select all four points.
//
// Example 2:
//
// Input: side = 2, points = [[0,0],[1,2],[2,0],[2,2],[2,1]], k = 4
//
// Output: 1
//
// Explanation:
//
// 4080_example1_revised.png
//
// Select the points (0, 0), (2, 0), (2, 2), and (2, 1).
//
// Example 3:
//
// Input: side = 2, points = [[0,0],[0,1],[0,2],[1,2],[2,0],[2,2],[2,1]], k = 5
//
// Output: 1
//
// Explanation:
//
// 4080_example2_revised.png
//
// Select the points (0, 0), (0, 1), (0, 2), (1, 2), and (2, 2).
//
// Constraints:
//
// - 1 <= side <= 109
// - 4 <= points.length <= min(4 * side, 15 * 103)
// - points[i] == [xi, yi]
// - The input is generated such that: points[i] lies on the boundary of the square.
// - All points[i] are unique.
//
// 4

package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximizeTheDistanceBetweenPointsOnASquare {
    public static void main(String[] args) {
        MaximizeTheDistanceBetweenPointsOnASquare outer = new MaximizeTheDistanceBetweenPointsOnASquare();
        Solution solution = outer.new Solution();

        int[][] exampleOnePoints = { { 0, 2 }, { 2, 0 }, { 2, 2 }, { 0, 0 } };
        System.out.println(solution.maxDistance(2, exampleOnePoints, 4)); // expected: 2

        int[][] exampleTwoPoints = { { 0, 0 }, { 1, 2 }, { 2, 0 }, { 2, 2 }, { 2, 1 } };
        System.out.println(solution.maxDistance(2, exampleTwoPoints, 4)); // expected: 1

        int[][] exampleThreePoints = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 }, { 2, 2 }, { 2, 1 } };
        System.out.println(solution.maxDistance(2, exampleThreePoints, 5)); // expected: 1

        int[][] smallestSquarePoints = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        System.out.println(solution.maxDistance(1, smallestSquarePoints, 4)); // expected: 1

        int[][] cornersOnlyPoints = { { 0, 0 }, { 0, 3 }, { 3, 0 }, { 3, 3 } };
        System.out.println(solution.maxDistance(3, cornersOnlyPoints, 4)); // expected: 3

        int[][] preferCornersPoints = { { 0, 0 }, { 0, 4 }, { 4, 0 }, { 4, 4 }, { 2, 0 }, { 2, 4 } };
        System.out.println(solution.maxDistance(4, preferCornersPoints, 4)); // expected: 4
    }

    // leetcode submit region begin(Prohibit modification and deletion)

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class Solution {
        public int maxDistance(int side, int[][] points, int k) {
            List<int[][]> listPointK = combinations(points, k);
            int ans = Integer.MIN_VALUE;
            for (int[][] array : listPointK) {
                int minDistance = Arrays.stream(calDistances(array)).min().getAsInt();
                if (minDistance > ans) {
                    ans = minDistance;
                }
            }
            return ans;
        }

        public int[] calDistances(int[][] array) {
            List<int[][]> combination2 = combinations(array, 2);
            int[] ans = new int[combination2.size()];
            for (int i = 0; i < ans.length; i++) {
                Point p1 = new Point(combination2.get(i)[0][0], combination2.get(i)[0][1]);
                Point p2 = new Point(combination2.get(i)[1][0], combination2.get(i)[1][1]);
                ans[i] = calManhattanDistance(p1, p2);
            }
            return ans;
        }

        public List<int[][]> combinations(int[][] nums, int k) {
            List<int[][]> result = new ArrayList<>();
            backtrack(nums, k, 0, new int[k][2], 0, result);
            return result;
        }

        private void backtrack(int[][] nums, int k, int start,
                int[][] current, int size,
                List<int[][]> result) {
            if (size == k) {
                result.add(Arrays.copyOf(current, k));
                return;
            }

            for (int i = start; i <= nums.length - (k - size); i++) {
                current[size] = nums[i];
                backtrack(nums, k, i + 1, current, size + 1, result);
            }
        }

        public int calManhattanDistance(Point p1, Point p2) {
            return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
