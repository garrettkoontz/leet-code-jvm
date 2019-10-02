package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionRemoveDuplicatesTest {

    @Test
    void removeDuplicates() {
        int[] firstTest = new int[] {0,0,1,1,1,2,2,3,3,4};
        assertEquals(5,new SolutionRemoveDuplicates().removeDuplicates(firstTest));
        assertArrayEquals(new int[] {0,1,2,3,4}, Arrays.copyOfRange(firstTest, 0,5));
        int[] secondTest = new int[] {1,1,2};
        assertEquals(2,new SolutionRemoveDuplicates().removeDuplicates(secondTest));
        assertArrayEquals(new int[] {1,2}, Arrays.copyOfRange(secondTest, 0, 2));
    }
}