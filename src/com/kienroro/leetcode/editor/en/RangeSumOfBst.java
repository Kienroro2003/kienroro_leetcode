// Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range[low, high].
//
// Example 1:
//
// bst1.jpg
//
// Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
// Output: 32
// Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
//
// Example 2:
//
// bst2.jpg
//
// Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
// Output: 23
// Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
//
// Constraints:
//
// - The number of nodes in the tree is in the range [1, 2 * 104].
// - 1 <= Node.val <= 105
// - 1 <= low <= high <= 105
// - All Node.val are unique.

package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class RangeSumOfBst {
    public static void main(String[] args) {
        RangeSumOfBst outer = new RangeSumOfBst();
        Solution solution = outer.new Solution();

        runCase(1, solution, outer, new Integer[] { 10, 5, 15, 3, 7, null, 18 }, 7, 15, 32);
        runCase(2, solution, outer, new Integer[] { 10, 5, 15, 3, 7, 13, 18, 1, null, 6 }, 6, 10, 23);
        runCase(3, solution, outer, new Integer[] { 10 }, 10, 10, 10);
        runCase(4, solution, outer, new Integer[] { 10, 5, 15, 3, 7, 13, 18 }, 1, 4, 3);
        runCase(5, solution, outer, new Integer[] { 10, 5, 15, 3, 7, 13, 18 }, 16, 20, 18);
        runCase(6, solution, outer, new Integer[] { 10, 5, 15, 3, 7, 13, 18 }, 1, 20, 71);
    }

    private static void runCase(int caseNumber, Solution solution, RangeSumOfBst outer, Integer[] values, int low,
            int high, int expected) {
        int actual = solution.rangeSumBST(buildTree(outer, values), low, high);
        System.out.printf("case %d -> input: root=%s, low=%s, high=%s, actual: %s, expected: %s, pass: %s%n",
                caseNumber, java.util.Arrays.toString(values), low, high, actual, expected, actual == expected);
    }

    private static TreeNode buildTree(RangeSumOfBst outer, Integer[] values) {
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
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> stack = new ArrayDeque<>();
            int ans = 0;
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.val <= high && node.val >= low) {
                    ans += node.val;
                }
                if (node.left != null && node.val > high) {
                    stack.push(node.left);
                    continue;
                }
                if (node.right != null && node.val < low) {
                    stack.push(node.right);
                    continue;
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return ans;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
