// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
//
// tree.png
//
// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
//
// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
//
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
//
// Example 1:
//
// leaf-similar-1.jpg
//
// Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
// Output: true
//
// Example 2:
//
// leaf-similar-2.jpg
//
// Input: root1 = [1,2,3], root2 = [1,3,2]
// Output: false
//
// Constraints:
//
// - The number of nodes in each tree will be in the range [1, 200].
// - Both of the given trees will have values in the range [0, 200].

package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        LeafSimilarTrees outer = new LeafSimilarTrees();
        Solution solution = outer.new Solution();

        TreeNode sampleOneRoot1 = outer.new TreeNode(3,
                outer.new TreeNode(5,
                        outer.new TreeNode(6),
                        outer.new TreeNode(2,
                                outer.new TreeNode(7),
                                outer.new TreeNode(4))),
                outer.new TreeNode(1,
                        outer.new TreeNode(9),
                        outer.new TreeNode(8)));
        TreeNode sampleOneRoot2 = outer.new TreeNode(3,
                outer.new TreeNode(5,
                        outer.new TreeNode(6),
                        outer.new TreeNode(7)),
                outer.new TreeNode(1,
                        outer.new TreeNode(4),
                        outer.new TreeNode(2,
                                outer.new TreeNode(9),
                                outer.new TreeNode(8))));
        System.out.println(solution.leafSimilar(sampleOneRoot1, sampleOneRoot2)); // expected: true

        TreeNode sampleTwoRoot1 = outer.new TreeNode(1,
                outer.new TreeNode(2),
                outer.new TreeNode(3));
        TreeNode sampleTwoRoot2 = outer.new TreeNode(1,
                outer.new TreeNode(3),
                outer.new TreeNode(2));
        System.out.println(solution.leafSimilar(sampleTwoRoot1, sampleTwoRoot2)); // expected: false

        TreeNode sameLeavesDifferentShapeRoot1 = outer.new TreeNode(1,
                outer.new TreeNode(2),
                outer.new TreeNode(3));
        TreeNode sameLeavesDifferentShapeRoot2 = outer.new TreeNode(1,
                outer.new TreeNode(4,
                        outer.new TreeNode(2),
                        null),
                outer.new TreeNode(5,
                        null,
                        outer.new TreeNode(3)));
        System.out.println(solution.leafSimilar(sameLeavesDifferentShapeRoot1, sameLeavesDifferentShapeRoot2)); // expected:
                                                                                                                // true

        TreeNode differentOrderRoot1 = outer.new TreeNode(1,
                outer.new TreeNode(2),
                outer.new TreeNode(3));
        TreeNode differentOrderRoot2 = outer.new TreeNode(1,
                outer.new TreeNode(3),
                outer.new TreeNode(2));
        System.out.println(solution.leafSimilar(differentOrderRoot1, differentOrderRoot2)); // expected: false

        TreeNode differentLeafCountRoot1 = outer.new TreeNode(1,
                outer.new TreeNode(2),
                null);
        TreeNode differentLeafCountRoot2 = outer.new TreeNode(1,
                outer.new TreeNode(2),
                outer.new TreeNode(3));
        System.out.println(solution.leafSimilar(differentLeafCountRoot1, differentLeafCountRoot2)); // expected: false

        TreeNode singleNodeRoot1 = outer.new TreeNode(1);
        TreeNode singleNodeRoot2 = outer.new TreeNode(1);
        System.out.println(solution.leafSimilar(singleNodeRoot1, singleNodeRoot2)); // expected: true

        TreeNode differentSingleNodeRoot1 = outer.new TreeNode(1);
        TreeNode differentSingleNodeRoot2 = outer.new TreeNode(2);
        System.out.println(solution.leafSimilar(differentSingleNodeRoot1, differentSingleNodeRoot2)); // expected: false

        TreeNode sampleLeafTree1 = outer.new TreeNode(1,
                outer.new TreeNode(2),
                outer.new TreeNode(3));
        TreeNode sampleLeafTree2 = outer.new TreeNode(1,
                outer.new TreeNode(2),
                outer.new TreeNode(3));
        System.out.println(solution.leafSimilar(sampleLeafTree1, sampleLeafTree2)); // expected: false

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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null) {
                return false;
            }
            List<Integer> leavesRoot1 = new ArrayList<>();
            List<Integer> leavesRoot2 = new ArrayList<>();
            dfs(root1, leavesRoot1);
            dfs(root2, leavesRoot2);
            return leavesRoot1.equals(leavesRoot2);

        }

        public void dfs(TreeNode node, List<Integer> leaves) {
            if (node == null) {
                return;
            }
            if (node.right == null && node.left == null) {
                leaves.add(node.val);
                return;
            }
            dfs(node.left, leaves);
            dfs(node.right, leaves);

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
