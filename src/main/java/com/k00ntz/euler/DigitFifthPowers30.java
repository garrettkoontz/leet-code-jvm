package com.k00ntz.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * <p>
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 14 is not a sum it is not included.
 * <p>
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * <p>
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class DigitFifthPowers30 {

    public static List<Integer> digits(int i) {
        List<Integer> digits = new ArrayList<>();
        for (char c : Integer.toString(i).toCharArray()) {
            digits.add(c - '0');
        }
        return digits;
    }

    public static int sumOfDigitsToPower(List<Integer> digits, int power) {
        return digits.stream().mapToInt(x -> (int) Math.pow(x, power)).reduce(Integer::sum).getAsInt();
    }

    public static List<Integer> digitPowers(int p) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 2; i < (int) Math.pow(10, p + 2); i++) {
            if (i == sumOfDigitsToPower(digits(i), p)) {
                ints.add(i);
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        System.out.println(digitPowers(4).stream().reduce(Integer::sum).orElse(-1));
        System.out.println(digitPowers(5).stream().reduce(Integer::sum).orElse(-1));
    }
}
