package com.k00ntz.euler;

import java.util.HashMap;
import java.util.Map;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19
 * letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * <p>
 * <p>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115
 * (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 */
public class NumberLetterCounts17 {

    private static Map<Integer, String> numberMap = new HashMap<Integer, String>() {{
        put(1, "one");
        put(2, "two");
        put(3, "three");
        put(4, "four");
        put(5, "five");
        put(6, "six");
        put(7, "seven");
        put(8, "eight");
        put(9, "nine");
        put(10, "ten");
        put(11, "eleven");
        put(12, "twelve");
        put(13, "thirteen");
        put(14, "fourteen");
        put(15, "fifteen");
        put(16, "sixteen");
        put(17, "seventeen");
        put(18, "eighteen");
        put(19, "nineteen");
        put(20, "twenty");
        put(30, "thirty");
        put(40, "forty");
        put(50, "fifty");
        put(60, "sixty");
        put(70, "seventy");
        put(80, "eighty");
        put(90, "ninety");
        put(100, "hundred");
        put(1000, "thousand");
    }};

    public static String stringForNumber(int i) {
        if (numberMap.containsKey(i) && i % 100 != 0) {
            return numberMap.get(i);
        }
        if (i / 1000 >= 1) {
            StringBuilder sb = new StringBuilder(numberMap.get(i / 1000)).append(numberMap.get(1000));
            if (i % 1000 != 0) {
                sb.append(stringForNumber(i % 1000));
            }
            return sb.toString();
        }
        if (i / 100 >= 1) {
            StringBuilder sb = new StringBuilder(numberMap.get(i / 100)).append(numberMap.get(100));
            if (i % 100 != 0) {
                sb.append("and").append(stringForNumber(i % 100));
            }
            return sb.toString();
        }
        if (i / 10 >= 1) {
            StringBuilder sb = new StringBuilder(numberMap.get(i - (i % 10)));
            if (i % 10 != 0) {
                sb.append(stringForNumber(i % 10));
            }
            return sb.toString();
        }
        return "";
    }

    public static int countLettersInNumbers(int from, int to) {
        int count = 0;
        for (int i = from; i <= to; i++) {
            count += stringForNumber(i).length();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(stringForNumber(1));
        System.out.println(stringForNumber((342)));
        System.out.println(countLettersInNumbers(1, 5));
        System.out.println(countLettersInNumbers(1, 1000));
    }
}
