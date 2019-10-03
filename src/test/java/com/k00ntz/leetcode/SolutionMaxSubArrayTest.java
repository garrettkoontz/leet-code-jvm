package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionMaxSubArrayTest {

    @Test
    void maxSubArray() {
        assertEquals(21, new SolutionMaxSubArray().maxSubArray(new int[]{8,-19,5,-4,20}));
        assertEquals(6, new SolutionMaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(1, new SolutionMaxSubArray().maxSubArray(new int[]{-2, 1}));
    }

}