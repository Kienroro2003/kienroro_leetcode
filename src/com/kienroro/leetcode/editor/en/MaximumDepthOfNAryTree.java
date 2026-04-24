//Given a n-ary tree, find its maximum depth. 
//
// The maximum depth is the number of nodes along the longest path from the 
//root node down to the farthest leaf node. 
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: 3
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,
//null,12,null,13,null,null,14]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The total number of nodes is in the range [0, 10⁴]. 
// The depth of the n-ary tree is less than or equal to 1000. 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search 👍 2874 👎 96

package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class MaximumDepthOfNAryTree {
    public static void main(String[] args) {
        MaximumDepthOfNAryTree outer = new MaximumDepthOfNAryTree();
        Solution solution = outer.new Solution();

        System.out.println(solution.maxDepth(null)); // expected: 0

        Node singleNode = outer.new Node(1, List.of());
        System.out.println(outer.maxDepth(singleNode)); // expected: 1

        Node sampleOne = outer.new Node(1, List.of(
                outer.new Node(3, List.of(
                        outer.new Node(5, List.of()),
                        outer.new Node(6, List.of()))),
                outer.new Node(2, List.of()),
                outer.new Node(4, List.of())));
        System.out.println(outer.maxDepth(sampleOne)); // expected: 3

        Node sampleTwo = outer.new Node(1, List.of(
                outer.new Node(2, List.of()),
                outer.new Node(3, List.of(
                        outer.new Node(6, List.of()),
                        outer.new Node(7, List.of(
                                outer.new Node(11, List.of(
                                        outer.new Node(14, List.of()))))))),
                outer.new Node(4, List.of(
                        outer.new Node(8, List.of(
                                outer.new Node(12, List.of()))))),
                outer.new Node(5, List.of(
                        outer.new Node(9, List.of(
                                outer.new Node(13, List.of()))),
                        outer.new Node(10, List.of())))));
        System.out.println(outer.maxDepth(sampleTwo)); // expected: 5

        Node skewedTree = outer.new Node(1, List.of(
                outer.new Node(2, List.of(
                        outer.new Node(3, List.of(
                                outer.new Node(4, List.of())))))));
        System.out.println(outer.maxDepth(skewedTree)); // expected: 4
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class State {
        private Node node;
        private int depth;

        public State(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(Node root) {
        Deque<State> stack = new ArrayDeque<>();
        stack.push(new State(root, 1));
        int maximumDepth = 0;
        while (!stack.isEmpty()) {
            State state = stack.pop();
            maximumDepth = Math.max(maximumDepth, state.depth);
            for (Node node : state.node.children) {
                stack.push(new State(node, state.depth + 1));
            }
        }

        return maximumDepth;

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /*
     * // Definition for a Node.
     * class Node {
     * public int val;
     * public List<Node> children;
     * 
     * public Node() {}
     * 
     * public Node(int _val) {
     * val = _val;
     * }
     * 
     * public Node(int _val, List<Node> _children) {
     * val = _val;
     * children = _children;
     * }
     * };
     */

    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int depth = 0;
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                depth++;
                while (size-- > 0) {
                    Node curr = queue.poll();
                    for (Node node : curr.children) {
                        queue.offer(node);
                    }
                }
            }

            return depth;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}
