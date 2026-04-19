//Given the root of an n-ary tree, return the postorder traversal of its nodes' 
//values. 
//
// Nary-Tree input serialization is represented in their level order traversal. 
//Each group of children is separated by the null value (See examples) 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: [5,6,3,2,4,1]
// 
//
// Example 2: 
// 
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,
//null,12,null,13,null,null,14]
//Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
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
// Related Topics Stack Tree Depth-First Search 👍 2762 👎 119


package com.kienroro.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NAryTreePostorderTraversal {
    public static void main(String[] args) {
        NAryTreePostorderTraversal outer = new NAryTreePostorderTraversal();
        Solution solution = outer.new Solution();

        Node root0 = null;
        System.out.println(solution.postorder(root0)); // []

        Node root1 = outer.new Node(1);
        System.out.println(solution.postorder(root1)); // [1]

        Node root2 = outer.new Node(1, List.of(
                outer.new Node(2),
                outer.new Node(3),
                outer.new Node(4)
        ));
        System.out.println(solution.postorder(root2)); // [1, 2, 3, 4]

        Node root3 = outer.new Node(1, List.of(
                outer.new Node(3, List.of(
                        outer.new Node(5),
                        outer.new Node(6)
                )),
                outer.new Node(2),
                outer.new Node(4)
        ));
        System.out.println(solution.postorder(root3)); // [1, 3, 5, 6, 2, 4]

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
        System.out.println(solution.postorder(root4)); // [1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10]

        Node root5 = outer.new Node(1, List.of(
                outer.new Node(2, List.of(
                        outer.new Node(3, List.of(
                                outer.new Node(4)
                        ))
                ))
        ));
        System.out.println(solution.postorder(root5)); // [1, 2, 3, 4]

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
        System.out.println(solution.postorder(root6)); // [1, 2, 3, 6, 4, 5, 7, 8]

        Node root7 = outer.new Node(1, List.of());
        System.out.println(solution.postorder(root7)); // [1]

        System.out.println("Node 8");
        Node root8 = outer.new Node(1, List.of(
                outer.new Node(2, List.of(
                        outer.new Node(4),
                        outer.new Node(5)
                )),
                outer.new Node(3, List.of(
                        outer.new Node(6)
                ))
        ));
        System.out.println(solution.postorder(root8));
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
}
*/

    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<Node> rootStack = new Stack<>();
            rootStack.push(root);
            Stack<Node> reversedStack = new Stack<>();
            while (!rootStack.isEmpty()) {
                Node node = rootStack.pop();
                reversedStack.push(node);
                if (node.children != null) {
                    for (int i = 0; i < node.children.size(); i++) {
                        rootStack.push(node.children.get(i));
                    }
                }
            }
            reversedStack.addAll(rootStack);
            while (!reversedStack.isEmpty()) {
                result.add(reversedStack.pop().val);
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}