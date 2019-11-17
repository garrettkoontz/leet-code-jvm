package com.k00ntz.euler;

import com.k00ntz.euler.util.ListUtil;
import com.k00ntz.euler.util.Primes;

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
 * the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * <p>
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this
 * sum exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of
 * two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be
 * written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even
 * though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is less than
 * this limit.
 * <p>
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */
public class NonAbundantSums23 {

    private static int limit = 28123;

    private static boolean[] abundantNumbers = new boolean[limit + 1];

    static {
        for (int i = 1; i <= limit; i++) {
            if (isAbundant(i)) abundantNumbers[i] = true;
        }
    }

    public static int abundance(int i) {
        return Integer.compare(ListUtil.sum(Primes.properDivisors(i)), i);
    }

    public static boolean isAbundant(int i) {
        return abundance(i) > 0;
    }

    public static boolean isSumOf2Abundants(int n) {
        for (int i = 1; i < n; i++) {
            if (abundantNumbers[i] && abundantNumbers[n - i]) return true;
        }
        return false;
    }

    public static long positiveIntsNotSumsOfAbundantNumbers() {
        long sum = 0L;
        for (int i = 0; i < limit; i++) {
            if (!isSumOf2Abundants(i)) sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(positiveIntsNotSumsOfAbundantNumbers());
        //4207994
    }
}
