// Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.
//
// Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
//
// If no such second minimum value exists, output -1 instead.
//
// Example 1:
//
// smbt1.jpg
//
// Input: root = [2,2,5,null,null,5,7]
// Output: 5
// Explanation: The smallest value is 2, the second smallest value is 5.
//
// Example 2:
//
// smbt2.jpg
//
// Input: root = [2,2,2]
// Output: -1
// Explanation: The smallest value is 2, but there isn't any second smallest value.
//
// Constraints:
//
// - The number of nodes in the tree is in the range [1, 25].
// - 1 <= Node.val <= 231 - 1
// - root.val == min(root.left.val, root.right.val) for each internal node of the tree.

package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        SecondMinimumNodeInABinaryTree outer = new SecondMinimumNodeInABinaryTree();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        // Example:
        // int[] nums = {2, 7, 11, 15};
        // int target = 9;
        // int[] result = solution.twoSum(nums, target);
        // System.out.println(java.util.Arrays.toString(result));
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
        public int findSecondMinimumValue(TreeNode root) {
            return dfs(root, root.val);
        }

        public int dfs(TreeNode node, int minValue) {
            if (node == null) {
                return -1;
            }

            if (node.val > minValue) {
                return node.val;
            }

            int left = dfs(node.left, minValue);
            int right = dfs(node.right, minValue);

            if (left == -1) {
                return right;
            }

            if (right == -1) {
                return left;
            }

            return Math.min(right, left);
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)
}
