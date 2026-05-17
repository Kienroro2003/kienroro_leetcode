// Given the head of a singly linked list, return trueif it is apalindromeorfalseotherwise.
//
// Example 1:
//
// pal1linked-list.jpg
//
// Input: head = [1,2,2,1]
// Output: true
//
// Example 2:
//
// pal2linked-list.jpg
//
// Input: head = [1,2]
// Output: false
//
// Constraints:
//
// - The number of nodes in the list is in the range [1, 105].
// - 0 <= Node.val <= 9
//
// Follow up: Could you do it in O(n) time and O(1) space?

package com.kienroro.leetcode.editor.en;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        PalindromeLinkedList outer = new PalindromeLinkedList();
        Solution solution = outer.new Solution();

        System.out.println(solution.isPalindrome(buildList(outer, new int[] { 1, 2, 2, 1 }))); // expected: true
        System.out.println(solution.isPalindrome(buildList(outer, new int[] { 1, 2 }))); // expected: false
        System.out.println(solution.isPalindrome(buildList(outer, new int[] { 1 }))); // expected: true
        System.out.println(solution.isPalindrome(buildList(outer, new int[] { 1, 2, 3, 2, 1 }))); // expected: true
        System.out.println(solution.isPalindrome(buildList(outer, new int[] { 1, 2, 3, 4, 1 }))); // expected: false
        System.out.println(solution.isPalindrome(buildList(outer, new int[] { 0, 0, 0, 0 }))); // expected: true
    }

    private static ListNode buildList(PalindromeLinkedList outer, int[] values) {
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
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            slow = reverseList(slow);
            ListNode curr = head;
            while (curr != null && slow != null) {
                if (curr.val != slow.val) {
                    return false;
                }
                curr = curr.next;
                slow = slow.next;
            }

            return true;
        }

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
