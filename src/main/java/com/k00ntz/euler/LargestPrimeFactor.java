package com.k00ntz.euler;

import com.k00ntz.euler.util.PrimeUtils;

import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class LargestPrimeFactor {
    public static void main(String[] args) {
        LargestPrimeFactor largestPrimeFactor = new LargestPrimeFactor();
        System.out.println(largestPrimeFactor.maxFactor(13195));
        System.out.println(largestPrimeFactor.maxFactor(600851475143L));
    }

    //not particularly fast...
    public long maxFactor(long number) {
        List<Long> primes = PrimeUtils.generatePrimesUpTo((long) Math.ceil(Math.sqrt(number)));
        System.out.println("Finding max factor of " + number);
        for (int i = primes.size() - 1; i >= 0; i--) {
            long p = primes.get(i);
            if (number % p == 0) return p;
        }
        return -1L;
    }
}
