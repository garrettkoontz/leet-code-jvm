package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 * Euler discovered the remarkable quadratic formula:
 * <p>
 * n^2+n+41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39. However, when n=40,
 * 40^2+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,41^2+41+41 is clearly divisible by 41.
 * <p>
 * The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79. The
 * product of the coefficients, −79 and 1601, is −126479.
 * <p>
 * Considering quadratics of the form:
 * <p>
 * n^2+an+b, where |a|<1000 and |b|≤1000
 * <p>
 * where |n| is the modulus/absolute value of n
 * e.g. |11|=11 and |−4|=4
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of primes
 * for consecutive values of n, starting with n=0.
 */
public class QuadraticPrimes27 {

    public static Set<Integer> primes = new HashSet<>(Primes.sieveOfEratosthenes(10000000));

    public static int numberOfPrimes(int a, int b) {
        int i = 0;
        while (primes.contains(i * i + i * a + b)) {
            i++;
        }
        return i;
    }

    public static int multipleOfMaxPrimes(int aRangeExclusvie, int bRangeInclusive) {
        int maxPrimes = 0;
        int maxA = 0;
        int maxB = 0;
        for (int i = -aRangeExclusvie + 1; i < aRangeExclusvie; i++) {
            for (int j = -bRangeInclusive; j <= bRangeInclusive; j++) {
                int numberOfPrimes = numberOfPrimes(i, j);
                if (numberOfPrimes > maxPrimes) {
                    maxA = i;
                    maxB = j;
                    maxPrimes = numberOfPrimes;
                }
            }
        }
        return maxA * maxB;
    }

    public static void main(String[] args) {
        System.out.println(numberOfPrimes(1, 41));
        System.out.println(numberOfPrimes(-79, 1601));
        System.out.println(multipleOfMaxPrimes(1000, 1000));
    }

}
