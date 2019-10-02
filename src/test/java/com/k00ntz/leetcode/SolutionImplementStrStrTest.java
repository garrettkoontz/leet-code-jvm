package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionImplementStrStrTest {

    @Test
    void strStr() {
        SolutionImplementStrStr solution = new SolutionImplementStrStr();
        assertEquals(4, solution.strStr("hello", "o"));
        assertEquals(-1, solution.strStr("hello", "ohheck"));
        assertEquals(2, solution.strStr("hello", "ll"));
        assertEquals(-1, solution.strStr("aaaaa", "bba"));
        assertEquals(0, solution.strStr("aaaaa", ""));
    }
}