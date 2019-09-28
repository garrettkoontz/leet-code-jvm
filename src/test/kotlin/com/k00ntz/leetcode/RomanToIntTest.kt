package com.k00ntz.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class RomanToIntTest {

    @Test
    fun romanToIntTest() {
        assertEquals(3,romanToInt("III"))
        assertEquals(4,romanToInt("IV"))
        assertEquals(5,romanToInt("V"))
        assertEquals(2400,romanToInt("MMCD"))
    }
}