// Given the root of a binary tree, return the length of the diameter of the tree.
//
// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
//
// The length of a path between two nodes is represented by the number of edges between them.
//
// Example 1:
//
// diamtree.jpg
//
// Input: root = [1,2,3,4,5]
// Output: 3
// Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
//
// Example 2:
//
// Input: root = [1,2]
// Output: 1
//
// Constraints:
//
// - The number of nodes in the tree is in the range [1, 104].
// - -100 <= Node.val <= 100

package com.kienroro.leetcode.editor.en;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        DiameterOfBinaryTree outer = new DiameterOfBinaryTree();
        Solution solution = outer.new Solution();

        System.out.println(solution.diameterOfBinaryTree(buildTree(outer, new Integer[] { 1, 2, 3, 4, 5 }))); // expected:
                                                                                                              // 3
        System.out.println(solution.diameterOfBinaryTree(buildTree(outer, new Integer[] { 1, 2 }))); // expected: 1
        System.out.println(solution.diameterOfBinaryTree(buildTree(outer, new Integer[] { 1 }))); // expected: 0
        System.out.println(solution.diameterOfBinaryTree(buildTree(outer, new Integer[] { 1, 2, 3 }))); // expected: 2
        System.out.println(solution.diameterOfBinaryTree(buildTree(outer, new Integer[] { 1, 2, null, 3, null, 4 }))); // expected:
                                                                                                                       // 3
        System.out
                .println(solution.diameterOfBinaryTree(buildTree(outer, new Integer[] { 1, 2, 3, 4, null, null, 5 }))); // expected:
                                                                                                                        // 4
    }

    private static TreeNode buildTree(DiameterOfBinaryTree outer, Integer[] values) {
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
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int diameter = depth(root.left) + depth(root.right);
            diameter = Math.max(diameter, diameterOfBinaryTree(root.left));
            diameter = Math.max(diameter, diameterOfBinaryTree(root.right));

            return diameter;

        }

        public int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
