// Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//
// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
//
// Example 1:
//
// ex1.jpg
//
// Input: p = [1,2,3], q = [1,2,3]
// Output: true
//
// Example 2:
//
// ex2.jpg
//
// Input: p = [1,2], q = [1,null,2]
// Output: false
//
// Example 3:
//
// ex3.jpg
//
// Input: p = [1,2,1], q = [1,1,2]
// Output: false
//
// Constraints:
//
// - The number of nodes in both trees is in the range [0, 100].
// - -104 <= Node.val <= 104

package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {
    public static void main(String[] args) {
        SameTree outer = new SameTree();
        Solution solution = outer.new Solution();

        runCase(1, solution, outer, new Integer[] { 1, 2, 3 }, new Integer[] { 1, 2, 3 }, true);
        runCase(2, solution, outer, new Integer[] { 1, 2 }, new Integer[] { 1, null, 2 }, false);
        runCase(3, solution, outer, new Integer[] { 1, 2, 1 }, new Integer[] { 1, 1, 2 }, false);
        runCase(4, solution, outer, new Integer[] {}, new Integer[] {}, true);
        runCase(5, solution, outer, new Integer[] {}, new Integer[] { 0 }, false);
        runCase(6, solution, outer, new Integer[] { 1, null, 2 }, new Integer[] { 1, null, 2 }, true);
        runCase(7, solution, outer, new Integer[] { 1, 2, null, 3 }, new Integer[] { 1, 2, null, null, 3 }, false);
    }

    private static void runCase(int caseNumber, Solution solution, SameTree outer, Integer[] pValues, Integer[] qValues,
            boolean expected) {
        boolean actual = solution.isSameTree(buildTree(outer, pValues), buildTree(outer, qValues));
        System.out.printf("case %d -> actual: %s, expected: %s, pass: %s%n", caseNumber, actual, expected,
                actual == expected);
    }

    private static TreeNode buildTree(SameTree outer, Integer[] values) {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            Deque<TreeNode> stackP = new ArrayDeque<>();
            Deque<TreeNode> stackQ = new ArrayDeque<>();
            stackP.push(p);
            stackQ.push(q);
            while (!stackP.isEmpty() || !stackQ.isEmpty()) {
                TreeNode nodeP = stackP.pop();
                TreeNode nodeQ = stackQ.pop();
                if (nodeP.val != nodeQ.val) {
                    return false;
                }
                if ((nodeP.left == null && nodeQ.left != null) || (nodeP.left != null && nodeQ.left == null)) {
                    return false;
                }
                if ((nodeP.right == null && nodeQ.right != null) || (nodeP.right != null && nodeQ.right == null)) {
                    return false;
                }
                if (nodeP.right != null)
                    stackP.push(nodeP.right);
                if (nodeP.left != null)
                    stackP.push(nodeP.left);
                if (nodeQ.right != null)
                    stackQ.push(nodeQ.right);
                if (nodeQ.left != null)
                    stackQ.push(nodeQ.left);
            }

            return stackP.isEmpty() && stackQ.isEmpty();

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
