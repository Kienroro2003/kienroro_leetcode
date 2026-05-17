// You are given the root of a full binary tree with the following properties:
//
// - Leaf nodes have either the value 0 or 1, where 0 represents False and 1 represents True.
// - Non-leaf nodes have either the value 2 or 3, where 2 represents the boolean OR and 3 represents the boolean AND.
//
// The evaluation of a node is as follows:
//
// - If the node is a leaf node, the evaluation is the value of the node, i.e. True or False.
// - Otherwise, evaluate the node's two children and apply the boolean operation of its value with the children's evaluations.
//
// Returnthe boolean result of evaluating therootnode.
//
// A full binary tree is a binary tree where each node has either 0 or 2 children.
//
// A leaf node is a node that has zero children.
//
// Example 1:
//
// example1drawio1.png
//
// Input: root = [2,1,3,null,null,0,1]
// Output: true
// Explanation: The above diagram illustrates the evaluation process.
// The AND node evaluates to False AND True = False.
// The OR node evaluates to True OR False = True.
// The root node evaluates to True, so we return true.
//
// Example 2:
//
// Input: root = [0]
// Output: false
// Explanation: The root node is a leaf node and it evaluates to false, so we return false.
//
// Constraints:
//
// - The number of nodes in the tree is in the range [1, 1000].
// - 0 <= Node.val <= 3
// - Every node has either 0 or 2 children.
// - Leaf nodes have a value of 0 or 1.
// - Non-leaf nodes have a value of 2 or 3.

package com.kienroro.leetcode.editor.en;

public class EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        EvaluateBooleanBinaryTree outer = new EvaluateBooleanBinaryTree();
        Solution solution = outer.new Solution();

        runCase(1, solution, outer, new Integer[] { 2, 1, 3, null, null, 0, 1 }, true);
        runCase(2, solution, outer, new Integer[] { 0 }, false);
        runCase(3, solution, outer, new Integer[] { 1 }, true);
        runCase(4, solution, outer, new Integer[] { 3, 1, 0 }, false);
        runCase(5, solution, outer, new Integer[] { 2, 0, 0 }, false);
        runCase(6, solution, outer, new Integer[] { 2, 3, 3, 1, 0, 1, 1 }, true);
        runCase(7, solution, outer, new Integer[] { 3, 2, 3, 0, 1, 1, 0 }, false);
    }

    private static void runCase(int caseNumber, Solution solution, EvaluateBooleanBinaryTree outer, Integer[] values,
            boolean expected) {
        boolean actual = solution.evaluateTree(buildTree(outer, values));
        System.out.printf("case %d -> input: root=%s, actual: %s, expected: %s, pass: %s%n",
                caseNumber, java.util.Arrays.toString(values), actual, expected, actual == expected);
    }

    private static TreeNode buildTree(EvaluateBooleanBinaryTree outer, Integer[] values) {
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
        public boolean evaluateTree(TreeNode root) {
            if (root.left == null && root.right == null) {
                return root.val == 1;
            }

            boolean leftEval = evaluateTree(root.left);
            boolean rightEval = evaluateTree(root.right);

            if (root.val == 2) {
                return leftEval || rightEval;
            } else { // root.val == 3
                return leftEval && rightEval;
            }

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
