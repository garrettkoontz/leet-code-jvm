package com.k00ntz.euler;

import com.k00ntz.euler.util.Primes;

import java.util.List;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 */
public class Prime100016 {

    public static int findNthPrime(int n) {
        List<Integer> primes = Primes.segmentedSieve(n);
        while (primes.size() < n) {
            primes = Primes.segmentedSieve(2 * primes.get(primes.size() - 1), primes);
        }
        return primes.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(findNthPrime(6));
        System.out.println(findNthPrime(10001));
    }
}
