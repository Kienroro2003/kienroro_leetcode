// Given the root of a binary tree, invert the tree, and return its root.
//
// Example 1:
//
// invert1-tree.jpg
//
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]
//
// Example 2:
//
// invert2-tree.jpg
//
// Input: root = [2,1,3]
// Output: [2,3,1]
//
// Example 3:
//
// Input: root = []
// Output: []
//
// Constraints:
//
// - The number of nodes in the tree is in the range [0, 100].
// - -100 <= Node.val <= 100

package com.kienroro.leetcode.editor.en;

public class InvertBinaryTree {
    public static void main(String[] args) {
        InvertBinaryTree outer = new InvertBinaryTree();
        Solution solution = outer.new Solution();

        System.out.println(
                treeToListString(solution.invertTree(buildTree(outer, new Integer[] { 4, 2, 7, 1, 3, 6, 9 })))); // expected:
                                                                                                                 // [4,
                                                                                                                 // 7,
                                                                                                                 // 2,
                                                                                                                 // 9,
                                                                                                                 // 6,
                                                                                                                 // 3,
                                                                                                                 // 1]
        System.out.println(treeToListString(solution.invertTree(buildTree(outer, new Integer[] { 2, 1, 3 })))); // expected:
                                                                                                                // [2,
                                                                                                                // 3, 1]
        System.out.println(treeToListString(solution.invertTree(buildTree(outer, new Integer[] {})))); // expected: []
        System.out.println(treeToListString(solution.invertTree(buildTree(outer, new Integer[] { 1 })))); // expected:
                                                                                                          // [1]
        System.out.println(
                treeToListString(solution.invertTree(buildTree(outer, new Integer[] { 1, 2, null, 3, null, 4 })))); // expected:
                                                                                                                    // [1,
                                                                                                                    // null,
                                                                                                                    // 2,
                                                                                                                    // null,
                                                                                                                    // 3,
                                                                                                                    // null,
                                                                                                                    // 4]
    }

    private static TreeNode buildTree(InvertBinaryTree outer, Integer[] values) {
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

    private static String treeToListString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        java.util.List<String> values = new java.util.ArrayList<>();
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == null) {
                values.add("null");
                continue;
            }

            values.add(String.valueOf(node.val));
            queue.add(node.left);
            queue.add(node.right);
        }

        int last = values.size() - 1;
        while (last >= 0 && values.get(last).equals("null")) {
            last--;
        }

        return "[" + String.join(", ", values.subList(0, last + 1)) + "]";
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);

            root.left = right;
            root.right = left;

            return root;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
