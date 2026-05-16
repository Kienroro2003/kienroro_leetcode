// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
//
// For example, the following two linked lists begin to intersect at node c1:
//
// 160_statement.png
// The test cases are generated such that there are no cycles anywhere in the entire linked structure.
//
// Note that the linked lists must retain their original structure after the function returns.
//
// Custom Judge:
//
// The inputs to the judge are given as follows (your program is not given these inputs):
//
// - intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
// - listA - The first linked list.
// - listB - The second linked list.
// - skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
// - skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
//
// The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
//
// Example 1:
//
// 160_example_1_1.png
//
// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
// Output: Intersected at '8'
// Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
// From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
// - Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references. In other words, they point to two different locations in memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
//
// Example 2:
//
// 160_example_2.png
//
// Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
// Output: Intersected at '2'
// Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
// From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
//
// Example 3:
//
// 160_example_3.png
//
// Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
// Output: No intersection
// Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
// Explanation: The two lists do not intersect, so return null.
//
// Constraints:
//
// - The number of nodes of listA is in the m.
// - The number of nodes of listB is in the n.
// - 1 <= m, n <= 3 * 104
// - 1 <= Node.val <= 105
// - 0 <= skipA <= m
// - 0 <= skipB <= n
// - intersectVal is 0 if listA and listB do not intersect.
// - intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
//
// Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?

package com.kienroro.leetcode.editor.en;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists outer = new IntersectionOfTwoLinkedLists();
        Solution solution = outer.new Solution();

        ListNode[] case1 = buildIntersectingLists(outer, new int[] { 4, 1 }, new int[] { 5, 6, 1 },
                new int[] { 8, 4, 5 });
        System.out.println(nodeToString(solution.getIntersectionNode(case1[0], case1[1]))); // expected: 8

        ListNode[] case2 = buildIntersectingLists(outer, new int[] { 1, 9, 1 }, new int[] { 3 }, new int[] { 2, 4 });
        System.out.println(nodeToString(solution.getIntersectionNode(case2[0], case2[1]))); // expected: 2

        ListNode[] case3 = buildSeparateLists(outer, new int[] { 2, 6, 4 }, new int[] { 1, 5 });
        System.out.println(nodeToString(solution.getIntersectionNode(case3[0], case3[1]))); // expected: null

        ListNode[] case4 = buildIntersectingLists(outer, new int[] {}, new int[] { 9, 8 }, new int[] { 7, 6 });
        System.out.println(nodeToString(solution.getIntersectionNode(case4[0], case4[1]))); // expected: 7

        ListNode[] case5 = buildSeparateLists(outer, new int[] { 1 }, new int[] { 1 });
        System.out.println(nodeToString(solution.getIntersectionNode(case5[0], case5[1]))); // expected: null
    }

    private static ListNode[] buildIntersectingLists(IntersectionOfTwoLinkedLists outer, int[] prefixA, int[] prefixB,
            int[] shared) {
        ListNode sharedHead = buildList(outer, shared);
        return new ListNode[] {
                appendSharedTail(outer, prefixA, sharedHead),
                appendSharedTail(outer, prefixB, sharedHead)
        };
    }

    private static ListNode[] buildSeparateLists(IntersectionOfTwoLinkedLists outer, int[] valuesA, int[] valuesB) {
        return new ListNode[] {
                buildList(outer, valuesA),
                buildList(outer, valuesB)
        };
    }

    private static ListNode appendSharedTail(IntersectionOfTwoLinkedLists outer, int[] prefix, ListNode sharedHead) {
        if (prefix.length == 0) {
            return sharedHead;
        }

        ListNode head = outer.new ListNode(prefix[0]);
        ListNode tail = head;

        for (int i = 1; i < prefix.length; i++) {
            tail.next = outer.new ListNode(prefix[i]);
            tail = tail.next;
        }

        tail.next = sharedHead;
        return head;
    }

    private static ListNode buildList(IntersectionOfTwoLinkedLists outer, int[] values) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = outer.new ListNode(values[0]);
        ListNode tail = head;

        for (int i = 1; i < values.length; i++) {
            tail.next = outer.new ListNode(values[i]);
            tail = tail.next;
        }

        return head;
    }

    private static String nodeToString(ListNode node) {
        return node == null ? "null" : String.valueOf(node.val);
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode curr = headA;
            Set<ListNode> set = new HashSet<>();
            while (curr != null) {
                set.add(curr);
                curr = curr.next;
            }
            curr = headB;
            while (curr != null) {
                if (set.contains(curr)) {
                    return curr;
                }
                curr = curr.next;
            }
            return null;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
