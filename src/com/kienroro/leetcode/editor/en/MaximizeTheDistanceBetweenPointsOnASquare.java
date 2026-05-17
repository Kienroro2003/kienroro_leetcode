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

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

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
    class Solution {
        public int maxDistance(int side, int[][] points, int k) {
            int[][] ordered = getOrderedPoints(side, points);
            int left = 0;
            int right = side;

            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (canPick(ordered, k, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }

        private int[][] getOrderedPoints(int side, int[][] points) {
            Integer[] order = new Integer[points.length];
            Arrays.setAll(order, i -> i);
            Arrays.sort(order, Comparator.comparingLong(i -> toPerimeterPosition(side, points[i][0], points[i][1])));

            int[][] ordered = new int[points.length][2];
            for (int i = 0; i < points.length; i++) {
                ordered[i] = points[order[i]];
            }
            return ordered;
        }

        private long toPerimeterPosition(int side, int x, int y) {
            if (y == 0) {
                return x;
            }
            if (x == side) {
                return (long) side + y;
            }
            if (y == side) {
                return 3L * side - x;
            }
            return 4L * side - y;
        }

        private boolean canPick(int[][] ordered, int k, int distance) {
            Deque<Sequence> deque = new ArrayDeque<>();
            deque.addLast(new Sequence(
                    ordered[0][0],
                    ordered[0][1],
                    ordered[0][0],
                    ordered[0][1],
                    1));

            int maxLength = 1;
            for (int i = 1; i < ordered.length; i++) {
                int x = ordered[i][0];
                int y = ordered[i][1];
                int startX = x;
                int startY = y;
                int length = 1;

                while (!deque.isEmpty() && manhattan(x, y, deque.peekFirst().endX, deque.peekFirst().endY) >= distance) {
                    Sequence previous = deque.pollFirst();
                    if (manhattan(x, y, previous.startX, previous.startY) >= distance
                            && previous.length + 1 >= length) {
                        startX = previous.startX;
                        startY = previous.startY;
                        length = previous.length + 1;
                        maxLength = Math.max(maxLength, length);
                    }
                }

                deque.addLast(new Sequence(startX, startY, x, y, length));
            }
            return maxLength >= k;
        }

        private int manhattan(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }

        private class Sequence {
            int startX;
            int startY;
            int endX;
            int endY;
            int length;

            Sequence(int startX, int startY, int endX, int endY, int length) {
                this.startX = startX;
                this.startY = startY;
                this.endX = endX;
                this.endY = endY;
                this.length = length;
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
