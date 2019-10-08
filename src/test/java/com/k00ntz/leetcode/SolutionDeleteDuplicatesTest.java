package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionDeleteDuplicatesTest {

    /*
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
    @Test
    void deleteDuplicates() {
        SolutionDeleteDuplicates deleteDuplicates = new SolutionDeleteDuplicates();
        assertEquals("1->2",
                deleteDuplicates.deleteDuplicates(SolutionDeleteDuplicates.ListNode.buildFromArray(
                        new int[]{1, 1, 2})).toString());
        assertEquals("1->2->3",
                deleteDuplicates.deleteDuplicates(SolutionDeleteDuplicates.ListNode.buildFromArray(
                        new int[]{1, 1, 2, 3, 3})).toString());
        assertEquals("1",
                deleteDuplicates.deleteDuplicates(SolutionDeleteDuplicates.ListNode.buildFromArray(
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1})).toString());
    }
}