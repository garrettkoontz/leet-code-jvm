package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionPlusOneTest {

    @Test
    void plusOne() {
        assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}, new SolutionPlusOne().plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        assertArrayEquals(new int[]{1}, new SolutionPlusOne().plusOne(new int[]{0}));
        assertArrayEquals(new int[]{1, 2, 4}, new SolutionPlusOne().plusOne(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{4, 3, 2, 2}, new SolutionPlusOne().plusOne(new int[]{4, 3, 2, 1}));
        assertArrayEquals(new int[]{1, 0}, new SolutionPlusOne().plusOne(new int[]{9}));
        assertArrayEquals(new int[]{1, 0, 0, 0, 0}, new SolutionPlusOne().plusOne(new int[]{9, 9, 9, 9}));
    }
}