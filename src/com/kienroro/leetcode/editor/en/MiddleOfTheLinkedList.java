// Given the head of a singly linked list, return the middle node of the linked list.
//
// If there are two middle nodes, return the second middle node.
//
// Example 1:
//
// lc-midlist1.jpg
//
// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.
//
// Example 2:
//
// lc-midlist2.jpg
//
// Input: head = [1,2,3,4,5,6]
// Output: [4,5,6]
// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
//
// Constraints:
//
// - The number of nodes in the list is in the range [1, 100].
// - 1 <= Node.val <= 100

package com.kienroro.leetcode.editor.en;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        MiddleOfTheLinkedList outer = new MiddleOfTheLinkedList();
        Solution solution = outer.new Solution();

        System.out.println(listToString(solution.middleNode(buildList(outer, new int[] { 1, 2, 3, 4, 5 })))); // expected:
                                                                                                              // [3, 4,
                                                                                                              // 5]
        System.out.println(listToString(solution.middleNode(buildList(outer, new int[] { 1, 2, 3, 4, 5, 6 })))); // expected:
                                                                                                                 // [4,
                                                                                                                 // 5,
                                                                                                                 // 6]
        System.out.println(listToString(solution.middleNode(buildList(outer, new int[] { 1 })))); // expected: [1]
        System.out.println(listToString(solution.middleNode(buildList(outer, new int[] { 1, 2 })))); // expected: [2]
        System.out
                .println(listToString(solution.middleNode(buildList(outer, new int[] { 10, 20, 30, 40, 50, 60, 70 })))); // expected:
                                                                                                                         // [40,
                                                                                                                         // 50,
                                                                                                                         // 60,
                                                                                                                         // 70]
    }

    private static ListNode buildList(MiddleOfTheLinkedList outer, int[] values) {
        ListNode head = outer.new ListNode(values[0]);
        ListNode tail = head;

        for (int i = 1; i < values.length; i++) {
            tail.next = outer.new ListNode(values[i]);
            tail = tail.next;
        }

        return head;
    }

    private static String listToString(ListNode head) {
        StringBuilder result = new StringBuilder("[");

        while (head != null) {
            if (result.length() > 1) {
                result.append(", ");
            }
            result.append(head.val);
            head = head.next;
        }

        return result.append("]").toString();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
