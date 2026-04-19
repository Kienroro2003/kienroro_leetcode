//Given the root of a binary search tree, rearrange the tree in in-order so 
//that the leftmost node in the tree is now the root of the tree, and every node has 
//no left child and only one right child. 
//
// 
// Example 1: 
// 
// 
//Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
//Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
// 
//
// Example 2: 
// 
// 
//Input: root = [5,1,7]
//Output: [1,null,5,null,7]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the given tree will be in the range [1, 100]. 
// 0 <= Node.val <= 1000 
// 
//
// Related Topics Stack Tree Depth-First Search Binary Search Tree Binary Tree ?
//? 4488 👎 685


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        IncreasingOrderSearchTree outer = new IncreasingOrderSearchTree();
        Solution solution = outer.new Solution();

        // TODO: Setup local test data here.
        TreeNode t1 = outer.new TreeNode(5,
                outer.new TreeNode(3,
                        outer.new TreeNode(2,
                                outer.new TreeNode(1), null),
                        outer.new TreeNode(4)),
                outer.new TreeNode(6,
                        null,
                        outer.new TreeNode(8,
                                outer.new TreeNode(7),
                                outer.new TreeNode(9))));

        TreeNode t2 = outer.new TreeNode(5,
                outer.new TreeNode(1),
                outer.new TreeNode(7));

        TreeNode t3 = outer.new TreeNode(1);

        TreeNode t4 = outer.new TreeNode(1,
                null,
                outer.new TreeNode(2,
                        null,
                        outer.new TreeNode(3)));

        TreeNode t5 = outer.new TreeNode(4,
                outer.new TreeNode(3,
                        outer.new TreeNode(2,
                                outer.new TreeNode(1), null),
                        null),
                null);

        TreeNode t6 = outer.new TreeNode(4,
                outer.new TreeNode(2,
                        outer.new TreeNode(1),
                        outer.new TreeNode(3)),
                outer.new TreeNode(6,
                        outer.new TreeNode(5),
                        outer.new TreeNode(7)));

        TreeNode t7 = outer.new TreeNode(3,
                outer.new TreeNode(1,
                        null,
                        outer.new TreeNode(2)),
                null);

        TreeNode t8 = outer.new TreeNode(2,
                null,
                outer.new TreeNode(4,
                        outer.new TreeNode(3),
                        null));
        printRightChain(solution.increasingBST(t1)); // 1 2 3 4 5 6 7 8 9
        printRightChain(solution.increasingBST(t2)); // 1 5 7
        printRightChain(solution.increasingBST(t3)); // 1
        printRightChain(solution.increasingBST(t4)); // 1 2 3
        printRightChain(solution.increasingBST(t5)); // 1 2 3 4
        printRightChain(solution.increasingBST(t6)); // 1 2 3 4 5 6 7
        printRightChain(solution.increasingBST(t7)); // 1 2 3
        printRightChain(solution.increasingBST(t8)); // 2 3 4
    }

    private static void printRightChain(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            if (root.left != null) {
                System.out.print("(LEFT NOT NULL ERROR) ");
            }
            root = root.right;
        }
        System.out.println();
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
        public TreeNode increasingBST(TreeNode root) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            List<TreeNode> list = new ArrayList<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                list.add(curr);
                curr = curr.right;
            }
            TreeNode res = new TreeNode(list.get(0).val);
            curr = res;
            for (int i = 1; i < list.size(); i++) {
                curr.right = new TreeNode(list.get(i).val);
                curr = curr.right;
            }
            return res;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}