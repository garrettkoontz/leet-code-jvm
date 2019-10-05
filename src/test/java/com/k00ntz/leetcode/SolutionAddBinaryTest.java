package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionAddBinaryTest {

    @Test
    void addBinary() {
        SolutionAddBinary ab = new SolutionAddBinary();
        assertEquals("100", ab.addBinary("11", "1"));
        assertEquals("000", ab.addBinary("000", "0"));
        assertEquals("10101", ab.addBinary("1010", "1011"));
    }
}