// Given a binary tree, determine if it is height-balanced.
//
// Example 1:
//
// balance_1.jpg
//
// Input: root = [3,9,20,null,null,15,7]
// Output: true
//
// Example 2:
//
// balance_2.jpg
//
// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
//
// Example 3:
//
// Input: root = []
// Output: true
//
// Constraints:
//
// - The number of nodes in the tree is in the range [0, 5000].
// - -104 <= Node.val <= 104

package com.kienroro.leetcode.editor.en;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        BalancedBinaryTree outer = new BalancedBinaryTree();
        Solution solution = outer.new Solution();

        System.out.println(solution.isBalanced(buildTree(outer, new Integer[] { 3, 9, 20, null, null, 15, 7 }))); // expected:
                                                                                                                  // true
        System.out.println(solution.isBalanced(buildTree(outer, new Integer[] { 1, 2, 2, 3, 3, null, null, 4, 4 }))); // expected:
                                                                                                                      // false
        System.out.println(solution.isBalanced(buildTree(outer, new Integer[] {}))); // expected: true
        System.out.println(solution.isBalanced(buildTree(outer, new Integer[] { 1 }))); // expected: true
        System.out.println(solution.isBalanced(buildTree(outer, new Integer[] { 1, 2 }))); // expected: true
        System.out.println(solution.isBalanced(buildTree(outer, new Integer[] { 1, 2, null, 3, null, 4 }))); // expected:
                                                                                                             // false
        System.out.println(solution.isBalanced(buildTree(outer, new Integer[] { 1, 2, 3, 4, 5, null, null, 6 }))); // expected:
                                                                                                                   // false
    }

    private static TreeNode buildTree(BalancedBinaryTree outer, Integer[] values) {
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
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (Math.abs(leftHeight - rightHeight) > 1) {
                return false;
            }

            return isBalanced(root.left) && isBalanced(root.right);

        }

        public int height(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
