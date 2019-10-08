package com.k00ntz.leetcode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
class SolutionDeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        boolean hasNext = head.next != null;
        ListNode thisNode = head;
        while (hasNext) {
            if (thisNode.val == thisNode.next.val) {
                thisNode.next = thisNode.next.next;
                hasNext = thisNode.next != null;
            } else {
                thisNode = thisNode.next;
                hasNext = thisNode.next != null;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public static ListNode buildFromArray(int[] arr) {
            if (arr.length == 0) return null;
            ListNode head = new ListNode(arr[0]);
            ListNode thisNode = head;
            for (int i = 1; i < arr.length; i++) {
                thisNode.next = new ListNode(arr[i]);
                thisNode = thisNode.next;
            }
            return head;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + "->" + next.toString();
            } else return "" + val;
        }
    }
}
