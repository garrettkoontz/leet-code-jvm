package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionLengthOfLastWordTest {

    @Test
    void lengthOfLastWord() {
        assertEquals(5, new SolutionLengthOfLastWord().lengthOfLastWord("Hello World"));
        assertEquals(0, new SolutionLengthOfLastWord().lengthOfLastWord("       "));
        assertEquals(10, new SolutionLengthOfLastWord().lengthOfLastWord("HelloWorld"));
    }
}