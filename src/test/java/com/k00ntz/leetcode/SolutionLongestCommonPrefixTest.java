package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionLongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        assertEquals("", new SolutionLongestCommonPrefix().longestCommonPrefix(
                new String[]{""}
        ));
        assertEquals("fl", new SolutionLongestCommonPrefix().longestCommonPrefix(
                new String[]{"flowers", "flow", "flight"}
        ));
        assertEquals("", new SolutionLongestCommonPrefix().longestCommonPrefix(
                new String[]{"dog", "racecar", "car"}
        ));

    }
}