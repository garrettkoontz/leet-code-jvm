package com.k00ntz.euler.util;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {

    private static List<Long> factorialCache = new ArrayList<Long>() {{
        this.add(1L);
        this.add(1L);
    }};

    public static Long factorial(int i) {
        if (factorialCache.size() > i) {
            return factorialCache.get(i);
        } else {
            long fact = ((long) i) * factorial(i - 1);
            factorialCache.add(fact);
            return fact;
        }
    }

    public static List<Integer> getDigits(int i) {
        List<Integer> digits = new ArrayList<>();
        for (char c : ("" + i).toCharArray()) {
            digits.add(c - '0');
        }
        return digits;
    }
}
