// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
//
// A leaf is a node with no children.
//
// Example 1:
//
// pathsum1.jpg
//
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
// Output: true
// Explanation: The root-to-leaf path with the target sum is shown.
//
// Example 2:
//
// pathsum2.jpg
//
// Input: root = [1,2,3], targetSum = 5
// Output: false
// Explanation: There are two root-to-leaf paths in the tree:
// (1 --> 2): The sum is 3.
// (1 --> 3): The sum is 4.
// There is no root-to-leaf path with sum = 5.
//
// Example 3:
//
// Input: root = [], targetSum = 0
// Output: false
// Explanation: Since the tree is empty, there are no root-to-leaf paths.
//
// Constraints:
//
// - The number of nodes in the tree is in the range [0, 5000].
// - -1000 <= Node.val <= 1000
// - -1000 <= targetSum <= 1000

package com.kienroro.leetcode.editor.en;

public class PathSum {
    public static void main(String[] args) {
        PathSum outer = new PathSum();
        Solution solution = outer.new Solution();

        runCase(1, solution, outer, new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 }, 22,
                true);
        runCase(2, solution, outer, new Integer[] { 1, 2, 3 }, 5, false);
        runCase(3, solution, outer, new Integer[] {}, 0, false);
        runCase(4, solution, outer, new Integer[] { 1, 2 }, 1, false);
        runCase(5, solution, outer, new Integer[] { 1, 2 }, 3, true);
        runCase(6, solution, outer, new Integer[] { -2, null, -3 }, -5, true);
        runCase(7, solution, outer, new Integer[] { 1, -2, -3, 1, 3, -2, null, -1 }, -1, true);
    }

    private static void runCase(int caseNumber, Solution solution, PathSum outer, Integer[] values, int targetSum,
            boolean expected) {
        boolean actual = solution.hasPathSum(buildTree(outer, values), targetSum);
        System.out.printf("case %d -> input: root=%s, targetSum=%s, actual: %s, expected: %s, pass: %s%n",
                caseNumber, java.util.Arrays.toString(values), targetSum, actual, expected, actual == expected);
    }

    private static TreeNode buildTree(PathSum outer, Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = outer.new TreeNode(values[0]);
        java.util.Queue<TreeNode> queue = new java.util.ArrayDeque<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.remove();

            if (i < values.length && values[i] != null) {
                node.left = outer.new TreeNode(values[i]);
                queue.add(node.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                node.right = outer.new TreeNode(values[i]);
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return targetSum - root.val == 0;
            }

            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)
}
