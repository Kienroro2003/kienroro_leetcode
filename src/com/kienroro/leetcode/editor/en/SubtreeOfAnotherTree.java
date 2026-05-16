// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values ofsubRoot and false otherwise.
//
// A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.
//
// Example 1:
//
// subtree1-tree.jpg
//
// Input: root = [3,4,5,1,2], subRoot = [4,1,2]
// Output: true
//
// Example 2:
//
// subtree2-tree.jpg
//
// Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
// Output: false
//
// Constraints:
//
// - The number of nodes in the root tree is in the range [1, 2000].
// - The number of nodes in the subRoot tree is in the range [1, 1000].
// - -104 <= root.val <= 104
// - -104 <= subRoot.val <= 104

package com.kienroro.leetcode.editor.en;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        SubtreeOfAnotherTree outer = new SubtreeOfAnotherTree();
        Solution solution = outer.new Solution();

        runCase(1, solution, outer, new Integer[] { 3, 4, 5, 1, 2 }, new Integer[] { 4, 1, 2 }, true);
        runCase(2, solution, outer, new Integer[] { 3, 4, 5, 1, 2, null, null, null, null, 0 },
                new Integer[] { 4, 1, 2 }, false);
        runCase(3, solution, outer, new Integer[] { 1 }, new Integer[] { 1 }, true);
        runCase(4, solution, outer, new Integer[] { 1, 2, 3 }, new Integer[] { 2 }, true);
        runCase(5, solution, outer, new Integer[] { 1, 2, 3 }, new Integer[] { 4 }, false);
        runCase(6, solution, outer, new Integer[] { 1, 1 }, new Integer[] { 1 }, true);
        runCase(7, solution, outer, new Integer[] { 1, 2, 3, 4 }, new Integer[] { 2, 4 }, true);
        runCase(8, solution, outer, new Integer[] { 1, 2, 3, null, 4 }, new Integer[] { 2, 4 }, false);
    }

    private static void runCase(int caseNumber, Solution solution, SubtreeOfAnotherTree outer, Integer[] rootValues,
            Integer[] subRootValues, boolean expected) {
        boolean actual = solution.isSubtree(buildTree(outer, rootValues), buildTree(outer, subRootValues));
        System.out.printf("case %d %n-> input: root=%s, subRoot=%s%nactual: %s, expected: %s, pass: %s%n",
                caseNumber, java.util.Arrays.toString(rootValues), java.util.Arrays.toString(subRootValues), actual,
                expected, actual == expected);
    }

    private static TreeNode buildTree(SubtreeOfAnotherTree outer, Integer[] values) {
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }
            if (isSameTree(root, subRoot)) {
                return true;
            }
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
