package com.k00ntz.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 *
 */

public class SolutionRomanNumeral {
    public int romanToInt(String s) {
        return new RomanNumeral(s).toInt();
    }

    public static class RomanNumeral {

        private final String numeral;

        RomanNumeral(String numeral) {
            validateNumeral(numeral);
            this.numeral = numeral;
        }

        private void validateNumeral(String numeral) {
            for (char c : numeral.toCharArray()) {
                if (!charToInt.containsKey(c)) {
                    throw new IllegalArgumentException(String.format("character %c not allowed", c));
                }
            }
        }

        private static final HashMap<Character, Integer> charToInt = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        public int toInt() {
            final Deque<Integer> intList = getIntList();
            int result = 0;
            while (!intList.isEmpty()) {
                Integer f = intList.pollFirst();
                Integer n = intList.peekFirst() != null ? intList.peekFirst() : 0;
                if (f < n) {
                    result += (n - f);
                    intList.pollFirst();
                } else {
                    result += f;
                }
            }
            return result;
        }

        private Deque<Integer> getIntList() {
            final char[] charArray = numeral.toCharArray();
            final Deque<Integer> intList = new ArrayDeque<>();
            for (char c : charArray) {
                intList.add(charToInt.get(c));
            }
            return intList;
        }
    }
}
