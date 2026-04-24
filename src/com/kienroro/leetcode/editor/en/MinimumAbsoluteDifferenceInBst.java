//Given the root of a Binary Search Tree (BST), return the minimum absolute 
//difference between the values of any two different nodes in the tree. 
//
// 
// Example 1: 
// 
// 
//Input: root = [4,2,6,1,3]
//Output: 1
// 
//
// Example 2: 
// 
// 
//Input: root = [1,0,48,null,null,12,49]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁴]. 
// 0 <= Node.val <= 10⁵ 
// 
//
// 
// Note: This question is the same as 783: https://leetcode.com/problems/
//minimum-distance-between-bst-nodes/ 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Search 
//Tree Binary Tree 👍 4761 👎 276


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinimumAbsoluteDifferenceInBst {
    public static void main(String[] args) {
        MinimumAbsoluteDifferenceInBst outer = new MinimumAbsoluteDifferenceInBst();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        TreeNode t1 = outer.new TreeNode(4,
                outer.new TreeNode(2,
                        outer.new TreeNode(1),
                        outer.new TreeNode(3)),
                outer.new TreeNode(6));
        System.out.println(solution.getMinimumDifference(t1)); // expected: 1

        TreeNode t2 = outer.new TreeNode(1,
                outer.new TreeNode(0),
                outer.new TreeNode(48,
                        outer.new TreeNode(12),
                        outer.new TreeNode(49)));
        System.out.println(solution.getMinimumDifference(t2)); // expected: 1

        TreeNode t3 = outer.new TreeNode(1,
                null,
                outer.new TreeNode(3));
        System.out.println(solution.getMinimumDifference(t3)); // expected: 2

        TreeNode t4 = outer.new TreeNode(1,
                null,
                outer.new TreeNode(2,
                        null,
                        outer.new TreeNode(3,
                                null,
                                outer.new TreeNode(4))));
        System.out.println(solution.getMinimumDifference(t4)); // expected: 1

        TreeNode t5 = outer.new TreeNode(4,
                outer.new TreeNode(3,
                        outer.new TreeNode(2,
                                outer.new TreeNode(1),
                                null),
                        null),
                null);
        System.out.println(solution.getMinimumDifference(t5)); // expected: 1

        TreeNode t6 = outer.new TreeNode(236,
                outer.new TreeNode(104,
                        null,
                        outer.new TreeNode(227)),
                outer.new TreeNode(701,
                        null,
                        outer.new TreeNode(911)));
        System.out.println(solution.getMinimumDifference(t6)); // expected: 9

        TreeNode t7 = outer.new TreeNode(27,
                outer.new TreeNode(14,
                        outer.new TreeNode(10),
                        outer.new TreeNode(19)),
                outer.new TreeNode(35,
                        null,
                        outer.new TreeNode(42,
                                outer.new TreeNode(41),
                                null)));
        System.out.println(solution.getMinimumDifference(t7)); // expected: 1

        TreeNode t8 = outer.new TreeNode(10,
                outer.new TreeNode(4,
                        outer.new TreeNode(2),
                        outer.new TreeNode(7)),
                outer.new TreeNode(20,
                        outer.new TreeNode(15),
                        outer.new TreeNode(30)));
        System.out.println(solution.getMinimumDifference(t8)); // expected: 2
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


    //leetcode submit region begin(Prohibit modification and deletion)

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
        public int getMinimumDifference(TreeNode root) {
            int[] orderedValues = inorderTraversal(root);
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < orderedValues.length - 1; i++) {
                if (orderedValues[i + 1] - orderedValues[i] < minDiff) {
                    minDiff = orderedValues[i + 1] - orderedValues[i];
                }
            }
            return minDiff;

        }

        public int[] inorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode curr = root;
            List<Integer> res = new ArrayList<>();
            while (!stack.isEmpty() || curr != null) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            return res.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}