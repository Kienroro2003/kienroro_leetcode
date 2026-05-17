// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
//
// Example 1:
//
// removelinked-list.jpg
//
// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]
//
// Example 2:
//
// Input: head = [], val = 1
// Output: []
//
// Example 3:
//
// Input: head = [7,7,7,7], val = 7
// Output: []
//
// Constraints:
//
// - The number of nodes in the list is in the range [0, 104].
// - 1 <= Node.val <= 50
// - 0 <= val <= 50

package com.kienroro.leetcode.editor.en;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        RemoveLinkedListElements outer = new RemoveLinkedListElements();
        Solution solution = outer.new Solution();

        System.out
                .println(listToString(solution.removeElements(buildList(outer, new int[] { 1, 2, 6, 3, 4, 5, 6 }), 6))); // expected:
                                                                                                                         // [1,
                                                                                                                         // 2,
                                                                                                                         // 3,
                                                                                                                         // 4,
                                                                                                                         // 5]
        System.out.println(listToString(solution.removeElements(buildList(outer, new int[] {}), 1))); // expected: []
        System.out.println(listToString(solution.removeElements(buildList(outer, new int[] { 7, 7, 7, 7 }), 7))); // expected:
                                                                                                                  // []
        System.out.println(listToString(solution.removeElements(buildList(outer, new int[] { 1, 2, 3 }), 4))); // expected:
                                                                                                               // [1, 2,
                                                                                                               // 3]
        System.out.println(listToString(solution.removeElements(buildList(outer, new int[] { 6, 1, 2, 6 }), 6))); // expected:
                                                                                                                  // [1,
                                                                                                                  // 2]
        System.out.println(listToString(solution.removeElements(buildList(outer, new int[] { 1, 2, 6, 6 }), 6))); // expected:
                                                                                                                  // [1,
                                                                                                                  // 2]
    }

    private static ListNode buildList(RemoveLinkedListElements outer, int[] values) {
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
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode(0, head);
            ListNode current = dummy;
            while (current.next != null) {
                if (current.next.val == val) {
                    current.next = current.next.next;
                } else {
                    current = current.next;
                }
            }
            return dummy.next;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
