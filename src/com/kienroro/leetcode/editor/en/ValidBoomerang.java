//Given an array points where points[i] = [xi, yi] represents a point on the X-
//Y plane, return true if these points are a boomerang. 
//
// A boomerang is a set of three points that are all distinct and not in a 
//straight line. 
//
// 
// Example 1: 
// Input: points = [[1,1],[2,3],[3,2]]
//Output: true
// 
// Example 2: 
// Input: points = [[1,1],[2,2],[3,3]]
//Output: false
// 
// 
// Constraints: 
//
// 
// points.length == 3 
// points[i].length == 2 
// 0 <= xi, yi <= 100 
// 
//
// Related Topics Array Math Geometry 👍 467 👎 544


package com.kienroro.leetcode.editor.en;

public class ValidBoomerang {
    public static void main(String[] args) {
        ValidBoomerang outer = new ValidBoomerang();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        // Example:
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = solution.twoSum(nums, target);
        // System.out.println(java.util.Arrays.toString(result));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        record Point(int x, int y) {
        }

        public boolean isBoomerang(int[][] points) {
            Point p1 = new Point(points[0][0], points[0][1]);
            Point p2 = new Point(points[1][0], points[1][1]);
            Point p3 = new Point(points[2][0], points[2][1]);
            boolean areCollinear = (p2.x - p1.x) * (p3.y - p1.y) != (p2.y - p1.y) * (p3.x - p1.x);
            if (!areCollinear) {
                return false;
            }

            if (isCoincident(p1, p2) || isCoincident(p3, p2) || isCoincident(p1, p3)) {
                return false;
            }

            return true;
        }

        public boolean isCoincident(Point p1, Point p2){
            return p1.x == p2.x && p1.y == p2.y;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}