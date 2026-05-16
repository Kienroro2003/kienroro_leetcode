// Given the root of a binary tree, return its maximum depth.
//
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
// Example 1:
//
// Input: root = [3,9,20,null,null,15,7]
// Output: 3
//
// Example 2:
//
// Input: root = [1,null,2]
// Output: 2
//
// Constraints:
//
// - The number of nodes in the tree is in the range [0, 104].
// - -100 <= Node.val <= 100

package com.kienroro.leetcode.editor.en;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree outer = new MaximumDepthOfBinaryTree();
        Solution solution = outer.new Solution();

        System.out.println(solution.maxDepth(buildTree(outer, new Integer[] { 3, 9, 20, null, null, 15, 7 }))); // expected:
                                                                                                                // 3
        System.out.println(solution.maxDepth(buildTree(outer, new Integer[] { 1, null, 2 }))); // expected: 2
        System.out.println(solution.maxDepth(buildTree(outer, new Integer[] {}))); // expected: 0
        System.out.println(solution.maxDepth(buildTree(outer, new Integer[] { 1 }))); // expected: 1
        System.out.println(solution.maxDepth(buildTree(outer, new Integer[] { 1, 2, null, 3, null, 4 }))); // expected:
                                                                                                           // 4
        System.out.println(solution.maxDepth(buildTree(outer, new Integer[] { 1, 2, 3, 4, 5 }))); // expected: 3
    }

    private static TreeNode buildTree(MaximumDepthOfBinaryTree outer, Integer[] values) {
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
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
