// Given an integer array nums where the elements are sorted in ascending order, convert it to aheight-balanced binary search tree.
//
// Example 1:
//
// btree1.jpg
//
// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:
// btree2.jpg
//
// Example 2:
//
// btree.jpg
//
// Input: nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
//
// Constraints:
//
// - 1 <= nums.length <= 104
// - -104 <= nums[i] <= 104
// - nums is sorted in a strictly increasing order.

package com.kienroro.leetcode.editor.en;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree outer = new ConvertSortedArrayToBinarySearchTree();
        Solution solution = outer.new Solution();

        runCase(1, solution, new int[] { -10, -3, 0, 5, 9 });
        runCase(2, solution, new int[] { 1, 3 });
        runCase(3, solution, new int[] { 1 });
        runCase(4, solution, new int[] { -3, -2, -1, 0, 1, 2, 3 });
        runCase(5, solution, new int[] { -5, -2, 4, 8 });
    }

    private static void runCase(int caseNumber, Solution solution, int[] nums) {
        TreeNode actual = solution.sortedArrayToBST(nums);
        boolean pass = isBalanced(actual) && hasSameInorder(actual, nums);
        System.out.printf("case %d -> input: nums=%s, actual: %s, expected: balanced BST with same inorder, pass: %s%n",
                caseNumber, java.util.Arrays.toString(nums), treeToListString(actual), pass);
    }

    private static boolean hasSameInorder(TreeNode root, int[] nums) {
        java.util.List<Integer> values = new java.util.ArrayList<>();
        collectInorder(root, values);
        if (values.size() != nums.length) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (values.get(i) != nums[i]) {
                return false;
            }
        }
        return true;
    }

    private static void collectInorder(TreeNode node, java.util.List<Integer> values) {
        if (node == null) {
            return;
        }
        collectInorder(node.left, values);
        values.add(node.val);
        collectInorder(node.right, values);
    }

    private static boolean isBalanced(TreeNode root) {
        return heightOrUnbalanced(root) != -1;
    }

    private static int heightOrUnbalanced(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = heightOrUnbalanced(node.left);
        int right = heightOrUnbalanced(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
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
            } else {
                values.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        int last = values.size() - 1;
        while (last >= 0 && values.get(last).equals("null")) {
            last--;
        }
        return values.subList(0, last + 1).toString();
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
        public TreeNode sortedArrayToBST(int[] nums) {
            return build(nums, 0, nums.length - 1);
        }

        private TreeNode build(int[] nums, int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = build(nums, left, mid - 1);
            node.right = build(nums, mid + 1, right);
            return node;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
