//Given head, the head of a linked list, determine if the linked list has a 
//cycle in it. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. 
//Note that pos is not passed as a parameter. 
//
// Return true if there is a cycle in the linked list. Otherwise, return false. 
//
//
// 
// Example 1: 
// 
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to 
//the 1st node (0-indexed).
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to 
//the 0th node.
// 
//
// Example 3: 
// 
// 
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
//
// Related Topics Hash Table Linked List Two Pointers 👍 17559 👎 1590


package com.kienroro.leetcode.editor.en;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle outer = new LinkedListCycle();
        Solution solution = outer.new Solution();

        ListNode case1 = buildCycleList(outer, new int[]{3, 2, 0, -4}, 1);
        ListNode case2 = buildCycleList(outer, new int[]{1, 2}, 0);
        ListNode case3 = buildCycleList(outer, new int[]{1}, -1);

        System.out.println("case 1 = " + solution.hasCycle(case1));
        System.out.println("case 2 = " + solution.hasCycle(case2));
        System.out.println("case 3 = " + solution.hasCycle(case3));
    }

    private static ListNode buildCycleList(LinkedListCycle outer, int[] values, int pos) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = outer.new ListNode(values[0]);
        ListNode tail = head;
        ListNode cycleEntry = pos == 0 ? head : null;

        for (int i = 1; i < values.length; i++) {
            tail.next = outer.new ListNode(values[i]);
            tail = tail.next;
            if (i == pos) {
                cycleEntry = tail;
            }
        }

        if (pos >= 0) {
            tail.next = cycleEntry;
        }

        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode slow = head, fast = head.next;
            while (fast.next != null && fast.next.next != null && fast != slow) {
                slow = slow.next;
                fast = fast.next.next;
            }
            if (fast == slow) return true;
            else return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
