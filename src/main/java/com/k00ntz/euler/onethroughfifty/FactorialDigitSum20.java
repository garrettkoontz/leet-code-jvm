package com.k00ntz.euler.onethroughfifty;

import java.math.BigInteger;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * <p>
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sum of the digits in the number 100!
 */
public class FactorialDigitSum20 {

    public static BigInteger factorial(int i) {
        BigInteger answer = new BigInteger("1");
        for (int j = 1; j <= i; j++) {
            answer = answer.multiply(new BigInteger("" + j));
        }
        return answer;
    }

    public static int sumDigitsOfFactorial(int i) {
        BigInteger factorial = factorial(i);
        int sum = 0;
        for (char c : factorial.toString().toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigitsOfFactorial(10));
        System.out.println(sumDigitsOfFactorial(100));
    }
}
