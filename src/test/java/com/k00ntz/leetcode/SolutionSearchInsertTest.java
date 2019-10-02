package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionSearchInsertTest {

    @Test
    void searchInsert() {
        SolutionSearchInsert solution = new SolutionSearchInsert();
        assertEquals(1, solution.searchInsert(new int[]{1, 3, 5, 6}, 2));
        assertEquals(4, solution.searchInsert(new int[]{1, 3, 5, 6, 8, 9, 10, 14, 26, 37, 48, 59, 79}, 7));
        assertEquals(2, solution.searchInsert(new int[]{1, 3, 5, 6}, 5));
        assertEquals(4, solution.searchInsert(new int[]{1, 3, 5, 6}, 7));
        assertEquals(0, solution.searchInsert(new int[]{1, 3, 5, 6}, 0));

    }
}