package com.k00ntz.euler;

import java.math.BigInteger;

import static java.lang.Math.pow;

/**
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * <p>
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class SelfPowers48 {

    private static long lastXDigitsOfSelfPowers(int x, int max) {
        BigInteger mod = new BigInteger(String.valueOf((long) pow(10, x)));
        BigInteger ans = new BigInteger(String.valueOf(0));
        for (int i = 1; i <= max; i++) {
            ans = (ans.add(new BigInteger(String.valueOf(i)).pow(i).mod(mod))).mod(mod);

        }
        return ans.longValue();
    }

    public static void main(String[] args) {
        System.out.println(lastXDigitsOfSelfPowers(11, 10));
        System.out.println(lastXDigitsOfSelfPowers(10, 1000));
    }
}
