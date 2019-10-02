package com.k00ntz.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */

public class SolutionMergeSortedLists {

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


        public static ListNode buildListNodeFromArray(int[] ints){
            if(ints.length == 0){
                return null;
            }
            ListNode retVal = new ListNode(ints[0]);
            ListNode loopVar = retVal;
            for (int i = 1; i < ints.length; i++) {
                loopVar.next = new ListNode(ints[i]);
                loopVar = loopVar.next;
            }
            return retVal;
        }

        @Override
        public String toString() {
            if (next == null) {
                return "" + val;
            } else {
                return val + "->" + next.toString();
            }
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ptr1;
        ListNode ptr2;
        ListNode mergedList = null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if (l1.val < l2.val) {
            ptr1 = l1.next;
            ptr2 = l2;
            mergedList = new ListNode(l1.val);
        } else {
            ptr1 = l1;
            ptr2 = l2.next;
            mergedList = new ListNode(l2.val);
        }
        ListNode nextNode = mergedList;
        while (ptr1 != null || ptr2 != null) {
            if (ptr1 == null) {
                nextNode.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next;
                nextNode = nextNode.next;
            } else if (ptr2 == null) {
                nextNode.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
                nextNode = nextNode.next;
            } else if (ptr1.val < ptr2.val) {
                nextNode.next = new ListNode(ptr1.val);
                ptr1 = ptr1.next;
                nextNode = nextNode.next;
            } else {
                nextNode.next = new ListNode(ptr2.val);
                ptr2 = ptr2.next;
                nextNode = nextNode.next;
            }
        }
        return mergedList;
    }

}
