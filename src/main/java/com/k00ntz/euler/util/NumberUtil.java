package com.k00ntz.euler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public static List<Integer> getDigits(long i) {
        List<Integer> digits = new ArrayList<>();
        for (char c : ("" + i).toCharArray()) {
            digits.add(c - '0');
        }
        return digits;
    }

    public static long getNumber(List<Integer> digits) {
        return Long.parseLong(digits.stream().map(x -> "" + x).collect(Collectors.joining()));
    }

    public static Pair<Integer, Integer> fractionReduction(Pair<Integer, Integer> pair) {
        int gcd = findGCD(pair._1, pair._2);
        return new Pair<>(pair._1 / gcd, pair._2 / gcd);
    }

    private static int findGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);
    }

    public static boolean isPalindrome(int i) {
        return isPalindrome("" + i);
    }

    public static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
        }
        return true;
    }

    public static List<Integer> range(int from, int toExclusive){
        List<Integer> rangeList = new ArrayList<>();
        for (int i = from; i < toExclusive; i++) {
            rangeList.add(i);
        }
        return rangeList;
    }
}
