package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionClimbingStairsTest {

    @Test
    void climbStairs() {
        SolutionClimbingStairs climbingStairs = new SolutionClimbingStairs();
        assertEquals(2, climbingStairs.climbStairs(2));
        assertEquals(3, climbingStairs.climbStairs(3));
        assertEquals(5, climbingStairs.climbStairs(4));
        assertEquals(10946, climbingStairs.climbStairs(20));
        assertEquals(17711, climbingStairs.climbStairs(21));
        assertEquals(28657, climbingStairs.climbStairs(22));
        assertEquals(46368, climbingStairs.climbStairs(23));
        assertEquals(75025, climbingStairs.climbStairs(24));
        assertEquals(121393, climbingStairs.climbStairs(25));
        assertEquals(1346269, climbingStairs.climbStairs(30));
        assertEquals(14930352, climbingStairs.climbStairs(35));
    }
}