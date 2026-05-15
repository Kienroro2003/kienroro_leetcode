// Given the head of a singly linked list, reverse the list, and return the reversed list.
//
// Example 1:
//
// rev1ex1.jpg
//
// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]
//
// Example 2:
//
// rev1ex2.jpg
//
// Input: head = [1,2]
// Output: [2,1]
//
// Example 3:
//
// Input: head = []
// Output: []
//
// Constraints:
//
// - The number of nodes in the list is the range [0, 5000].
// - -5000 <= Node.val <= 5000
//
// Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

package com.kienroro.leetcode.editor.en;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ReverseLinkedList outer = new ReverseLinkedList();
        Solution solution = outer.new Solution();

        System.out.println(listToString(solution.reverseList(buildList(outer, new int[] { 1, 2, 3, 4, 5 })))); // expected:
                                                                                                               // [5, 4,
                                                                                                               // 3, 2,
                                                                                                               // 1]
        System.out.println(listToString(solution.reverseList(buildList(outer, new int[] { 1, 2 })))); // expected: [2,
                                                                                                      // 1]
        System.out.println(listToString(solution.reverseList(buildList(outer, new int[] {})))); // expected: []
        System.out.println(listToString(solution.reverseList(buildList(outer, new int[] { 7 })))); // expected: [7]
        System.out.println(listToString(solution.reverseList(buildList(outer, new int[] { -1, 0, 5000 })))); // expected:
                                                                                                             // [5000,
                                                                                                             // 0, -1]
    }

    private static ListNode buildList(ReverseLinkedList outer, int[] values) {
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
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            curr.next = prev;
            return curr;

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
