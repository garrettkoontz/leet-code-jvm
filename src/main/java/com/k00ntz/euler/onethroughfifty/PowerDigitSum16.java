package com.k00ntz.euler.onethroughfifty;

import java.math.BigInteger;

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p>
 * What is the sum of the digits of the number 2^1000?
 */
public class PowerDigitSum16 {
    public static void main(String[] args) {
        System.out.println(sumOfTwoPowerDigits(15));
        System.out.println(sumOfTwoPowerDigits(1000));
    }

    private static int sumOfTwoPowerDigits(int i) {
        BigInteger powOf2 = new BigInteger("2").pow(i);
        int sum = 0;
        for (char c :
                powOf2.toString().toCharArray()) {
            sum += c - '0';
        }
        return sum;
    }
}
