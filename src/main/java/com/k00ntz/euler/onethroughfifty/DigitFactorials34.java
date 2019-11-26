package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.NumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * <p>
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * <p>
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class DigitFactorials34 {

    private static List<Long> precalcFacts = IntStream.range(0, 10).mapToLong(NumberUtil::factorial).boxed().collect(Collectors.toList());

    private static long digitFactorialSum(int i) {
        return NumberUtil.getDigits(i).stream().mapToLong(NumberUtil::factorial).sum();
    }

    public static List<Long> digitFactorials() {
        List<Long> digitFactorials = new ArrayList<>();
        for (int i = 10; i < 100000; i++) {
            if (i == digitFactorialSum(i)) digitFactorials.add((long) i);
        }
        return digitFactorials;
    }

    public static void main(String[] args) {
        System.out.println(digitFactorials().stream().mapToLong(x -> x).sum());
    }
}
