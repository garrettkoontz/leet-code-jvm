package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionRemoveElementTest {

    @Test
    void removeElement() {
        //[3,2,2,3], val = 3,
        int[] firstTest = new int[]{3, 2, 2, 3};
        assertEquals(2, new SolutionRemoveElement().removeElement(firstTest, 3));
        assertArrayEquals(new int[]{2, 2}, Arrays.copyOfRange(firstTest, 0, 2));
        //[0,1,2,2,3,0,4,2], val = 2,
        int[] secondTest = new int[]{0,1,2,2,3,0,4,2};
        assertEquals(5, new SolutionRemoveElement().removeElement(secondTest, 2));
        assertArrayEquals(new int[]{0,1,3,0,4}, Arrays.copyOfRange(secondTest, 0, 5));
    }
}