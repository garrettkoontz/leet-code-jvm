package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.Primes;

import java.util.List;

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class SummationOfPrimes10 {

    public static long sumOfPrimesBelow(int i){
        List<Integer> primes = Primes.segmentedSieve(i);
        return primes.parallelStream().mapToLong(x -> (long) x).reduce(Long::sum).orElse(-1L);
    }

    public static void main(String[] args) {
        System.out.println(sumOfPrimesBelow(10));
        System.out.println(sumOfPrimesBelow(2000000));
    }
}
