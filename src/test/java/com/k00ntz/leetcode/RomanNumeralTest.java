package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumeralTest {

    @Test
    void toIntTest() {
        assertEquals(3, new SolutionRomanNumeral.RomanNumeral("III").toInt());
        assertEquals(4, new SolutionRomanNumeral.RomanNumeral("IV").toInt());
        assertEquals(5, new SolutionRomanNumeral.RomanNumeral("V").toInt());
        assertEquals(2400, new SolutionRomanNumeral.RomanNumeral("MMCD").toInt());
    }
}