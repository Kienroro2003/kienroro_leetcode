// You are given the heads of two sorted linked lists list1 and list2.
//
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
// Return the head of the merged linked list.
//
// Example 1:
//
// merge_ex1.jpg
//
// Input: list1 = [1,2,4], list2 = [1,3,4]
// Output: [1,1,2,3,4,4]
//
// Example 2:
//
// Input: list1 = [], list2 = []
// Output: []
//
// Example 3:
//
// Input: list1 = [], list2 = [0]
// Output: [0]
//
// Constraints:
//
// - The number of nodes in both lists is in the range [0, 50].
// - -100 <= Node.val <= 100
// - Both list1 and list2 are sorted in non-decreasing order.

package com.kienroro.leetcode.editor.en;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        MergeTwoSortedLists outer = new MergeTwoSortedLists();
        Solution solution = outer.new Solution();

        System.out.println(listToString(solution.mergeTwoLists(
                buildList(outer, new int[] { 1, 2, 4 }),
                buildList(outer, new int[] { 1, 3, 4 })))); // expected: [1, 1, 2, 3, 4, 4]
        System.out.println(listToString(solution.mergeTwoLists(
                buildList(outer, new int[] {}),
                buildList(outer, new int[] {})))); // expected: []
        System.out.println(listToString(solution.mergeTwoLists(
                buildList(outer, new int[] {}),
                buildList(outer, new int[] { 0 })))); // expected: [0]
        System.out.println(listToString(solution.mergeTwoLists(
                buildList(outer, new int[] { -10, -3, 0 }),
                buildList(outer, new int[] { -4, 2, 8 })))); // expected: [-10, -4, -3, 0, 2, 8]
        System.out.println(listToString(solution.mergeTwoLists(
                buildList(outer, new int[] { 1, 1, 2 }),
                buildList(outer, new int[] { 1, 1, 3 })))); // expected: [1, 1, 1, 1, 2, 3]
    }

    private static ListNode buildList(MergeTwoSortedLists outer, int[] values) {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            if (list1 == null && list2 != null) {
                return list2;
            }
            if (list1 != null && list2 == null) {
                return list1;
            }
            ListNode curr1 = list1.val <= list2.val ? list1 : list2;
            ListNode ans = curr1;
            ListNode curr2 = list1.val <= list2.val ? list2 : list1;
            ListNode prev = null;
            while (curr1 != null && curr2 != null) {
                while (curr1 != null && curr1.val <= curr2.val) {
                    prev = curr1;
                    curr1 = curr1.next;
                }
                prev.next = curr2;
                ListNode temp = curr2;
                curr2 = curr2.next;
                temp.next = curr1;
                curr1 = temp;
            }

            return ans;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)
}
