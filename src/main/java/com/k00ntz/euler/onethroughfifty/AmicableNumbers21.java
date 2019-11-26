package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.ListUtil;
import com.k00ntz.euler.util.Primes;

import java.util.HashSet;
import java.util.Set;

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class AmicableNumbers21 {
    public static int d(int n) {
        return ListUtil.sum(Primes.properDivisors(n));
    }

    public static boolean isAmicable(int a) {
        int da = d(a);
        int db = d(da);
        return a == db && da != db;
    }

    public static int sumOfAmicableNumbersBelow(int n) {
        Set<Integer> amicableNumbers = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (amicableNumbers.contains(i)) continue;
            int da = d(i);
            int db = d(da);
            if (i == db && da != db) {
                amicableNumbers.add(i);
                amicableNumbers.add(da);
            }
        }
        return ListUtil.sum(amicableNumbers);
    }

    public static void main(String[] args) {
        System.out.println(d(220));
        System.out.println(d(284));
        System.out.println(sumOfAmicableNumbersBelow(10000));
    }
}
