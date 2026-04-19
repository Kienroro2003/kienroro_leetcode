//Given the root of an n-ary tree, return the preorder traversal of its nodes' 
//values. 
//
// Nary-Tree input serialization is represented in their level order traversal. 
//Each group of children is separated by the null value (See examples) 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [1,3,5,6,2,4]
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,
//null,12,null,13,null,null,14]
//Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// 0 <= Node.val <= 10⁴ 
// The height of the n-ary tree is less than or equal to 1000. 
// 
//
// 
// Follow up: Recursive solution is trivial, could you do it iteratively? 
//
// Related Topics Stack Tree Depth-First Search 👍 3269 👎 204


package com.kienroro.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        NAryTreePreorderTraversal outer = new NAryTreePreorderTraversal();
        Solution solution = outer.new Solution();

        Node root0 = null;
        System.out.println(solution.preorder(root0)); // []

        Node root1 = outer.new Node(1);
        System.out.println(solution.preorder(root1)); // [1]

        Node root2 = outer.new Node(1, List.of(
                outer.new Node(2),
                outer.new Node(3),
                outer.new Node(4)
        ));
        System.out.println(solution.preorder(root2)); // [1, 2, 3, 4]

        Node root3 = outer.new Node(1, List.of(
                outer.new Node(3, List.of(
                        outer.new Node(5),
                        outer.new Node(6)
                )),
                outer.new Node(2),
                outer.new Node(4)
        ));
        System.out.println(solution.preorder(root3)); // [1, 3, 5, 6, 2, 4]

        Node root4 = outer.new Node(1, List.of(
                outer.new Node(2),
                outer.new Node(3, List.of(
                        outer.new Node(6),
                        outer.new Node(7, List.of(
                                outer.new Node(11, List.of(
                                        outer.new Node(14)
                                ))
                        ))
                )),
                outer.new Node(4, List.of(
                        outer.new Node(8, List.of(
                                outer.new Node(12)
                        ))
                )),
                outer.new Node(5, List.of(
                        outer.new Node(9, List.of(
                                outer.new Node(13)
                        )),
                        outer.new Node(10)
                ))
        ));
        System.out.println(solution.preorder(root4)); // [1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10]

        Node root5 = outer.new Node(1, List.of(
                outer.new Node(2, List.of(
                        outer.new Node(3, List.of(
                                outer.new Node(4)
                        ))
                ))
        ));
        System.out.println(solution.preorder(root5)); // [1, 2, 3, 4]

        Node root6 = outer.new Node(1, List.of(
                outer.new Node(2),
                outer.new Node(3, List.of(
                        outer.new Node(6)
                )),
                outer.new Node(4),
                outer.new Node(5, List.of(
                        outer.new Node(7),
                        outer.new Node(8)
                ))
        ));
        System.out.println(solution.preorder(root6)); // [1, 2, 3, 6, 4, 5, 7, 8]

        Node root7 = outer.new Node(1, List.of());
        System.out.println(solution.preorder(root7)); // [1]
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


    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                result.add(node.val);
                if (node.children != null) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}