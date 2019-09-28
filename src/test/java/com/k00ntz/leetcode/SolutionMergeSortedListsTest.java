package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionMergeSortedListsTest {

    @Test
    void mergeTwoLists() {
        assertEquals("1->1->2->3->4->4",
                new SolutionMergeSortedLists().mergeTwoLists(Objects.requireNonNull(SolutionMergeSortedLists.ListNode.buildListNodeFromArray(new int[]{1, 2, 4})),
                        Objects.requireNonNull(SolutionMergeSortedLists.ListNode.buildListNodeFromArray(new int[]{1, 3, 4}))).toString());
    }
}