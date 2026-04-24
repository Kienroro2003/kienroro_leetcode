// You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
//
// - For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
//
// For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
//
// The test cases are generated so that the answer fits in a 32-bits integer.
//
// Example 1:
//
// sum-of-root-to-leaf-binary-numbers.png
//
// Input: root = [1,0,1,0,1,0,1]
// Output: 22
// Explanation:(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
//
// Example 2:
//
// Input: root = [0]
// Output: 0
//
// Constraints:
//
// - The number of nodes in the tree is in the range [1, 1000].
// - Node.val is 0 or 1.

package com.kienroro.leetcode.editor.en;

public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        SumOfRootToLeafBinaryNumbers outer = new SumOfRootToLeafBinaryNumbers();
        Solution solution = outer.new Solution();

        TreeNode sampleOne = outer.new TreeNode(1,
                outer.new TreeNode(0,
                        outer.new TreeNode(0),
                        outer.new TreeNode(1)),
                outer.new TreeNode(1,
                        outer.new TreeNode(0),
                        outer.new TreeNode(1)));
        System.out.println(solution.sumRootToLeaf(sampleOne)); // expected: 22

        TreeNode sampleTwo = outer.new TreeNode(0);
        System.out.println(solution.sumRootToLeaf(sampleTwo)); // expected: 0

        TreeNode skewedLeft = outer.new TreeNode(1,
                outer.new TreeNode(1,
                        outer.new TreeNode(0,
                                outer.new TreeNode(1),
                                null),
                        null),
                null);
        System.out.println(solution.sumRootToLeaf(skewedLeft)); // expected: 13

        TreeNode leadingZeroPaths = outer.new TreeNode(0,
                outer.new TreeNode(1,
                        outer.new TreeNode(1),
                        outer.new TreeNode(0)),
                outer.new TreeNode(0,
                        outer.new TreeNode(1),
                        outer.new TreeNode(1)));
        System.out.println(solution.sumRootToLeaf(leadingZeroPaths)); // expected: 6

        TreeNode twoLeaves = outer.new TreeNode(1,
                outer.new TreeNode(0),
                outer.new TreeNode(1));
        System.out.println(solution.sumRootToLeaf(twoLeaves)); // expected: 5
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
        public int sumRootToLeaf(TreeNode root) {

            return dfs(root, "" + root.val);
        }

        public int dfs(TreeNode node, String chain) {
            if (node == null) {
                return 0;
            }
            if (node.left == null && node.right == null) {
                // System.out.println(chain + " " + Integer.parseInt(chain, 2));
                return Integer.parseInt(chain, 2);
            }
            int left = 0;
            if (node.left != null) {
                left = dfs(node.left, chain + node.left.val);
            }
            int right = 0;
            if (node.right != null) {
                right = dfs(node.right, chain + node.right.val);
            }
            return left + right;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
