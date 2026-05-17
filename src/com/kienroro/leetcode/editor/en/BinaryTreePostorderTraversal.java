// Given the root of a binary tree, return the postorder traversal of its nodes' values.
//
// Example 1:
//
// Input: root = [1,null,2,3]
//
// Output: [3,2,1]
//
// Explanation:
//
// screenshot-2024-08-29-202743.png
//
// Example 2:
//
// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]
//
// Output: [4,6,7,5,2,9,8,3,1]
//
// Explanation:
//
// tree_2.png
//
// Example 3:
//
// Input: root = []
//
// Output: []
//
// Example 4:
//
// Input: root = [1]
//
// Output: [1]
//
// Constraints:
//
// - The number of the nodes in the tree is in the range [0, 100].
// - -100 <= Node.val <= 100
//
// Follow up: Recursive solution is trivial, could you do it iteratively?

package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        BinaryTreePostorderTraversal outer = new BinaryTreePostorderTraversal();
        Solution solution = outer.new Solution();

        System.out.println(solution.postorderTraversal(buildTree(outer, new Integer[] { 1, null, 2, 3 }))); // expected:
                                                                                                            // [3, 2, 1]
        System.out.println(solution
                .postorderTraversal(buildTree(outer, new Integer[] { 1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9 }))); // expected:
                                                                                                                       // [4,
                                                                                                                       // 6,
                                                                                                                       // 7,
                                                                                                                       // 5,
                                                                                                                       // 2,
                                                                                                                       // 9,
                                                                                                                       // 8,
                                                                                                                       // 3,
                                                                                                                       // 1]
        System.out.println(solution.postorderTraversal(buildTree(outer, new Integer[] {}))); // expected: []
        System.out.println(solution.postorderTraversal(buildTree(outer, new Integer[] { 1 }))); // expected: [1]
        System.out.println(solution.postorderTraversal(buildTree(outer, new Integer[] { 2, 1, 3 }))); // expected: [1,
                                                                                                      // 3, 2]
        System.out.println(solution.postorderTraversal(buildTree(outer, new Integer[] { 1, 2, null, 3, null, 4 }))); // expected:
                                                                                                                     // [4,
                                                                                                                     // 3,
                                                                                                                     // 2,
                                                                                                                     // 1]
    }

    private static TreeNode buildTree(BinaryTreePostorderTraversal outer, Integer[] values) {
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
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode current = root;
            TreeNode lastVisited = null;

            while (!stack.isEmpty() || current != null) {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
                TreeNode node = stack.peek();
                if (node.right != null && node.right != lastVisited) {
                    current = node.right;
                } else {
                    result.add(node.val);
                    lastVisited = node;
                    stack.pop();
                }

            }
            return result;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
