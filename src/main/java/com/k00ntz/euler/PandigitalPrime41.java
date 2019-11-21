package com.k00ntz.euler;

import com.k00ntz.euler.util.Pandigital;
import com.k00ntz.euler.util.Primes;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example,
 * 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 */
public class PandigitalPrime41 {

    public static int pandigitalPrime() {
        int max = 0;
        List<Integer> primes = null;
        for (int i = 1; i < 10; i++) {
            primes = Primes.segmentedSieve((int) Math.pow(10, i), primes);
            Set<Integer> primesSet = new HashSet<>(primes);
            List<Integer> pandigitals = Pandigital.generateXDigitNumbers(i, Pandigital.allowedInts);
            pandigitals.removeIf(x -> !primesSet.contains(x));
            if (!pandigitals.isEmpty())
                max = Math.max(max, Collections.max(pandigitals));
        }
        return max;
    }

    public static int pandigitalPrimeCountdown() {
        final List<Integer> primes = Primes.segmentedSieve((int) ceil(sqrt(987654321)));
        for (int i = 9; i > 1; i--) {
            List<Integer> pandigitalAndPrime = Pandigital
                    .generateXDigitNumbers(i, IntStream.rangeClosed(1, i)
                            .boxed()
                            .collect(Collectors.toSet()))
                    .parallelStream()
                    .filter(p -> !isDivisibleInList(p, primes))
                    .collect(Collectors.toList());
            if (!pandigitalAndPrime.isEmpty())
                return Collections.max(pandigitalAndPrime);
        }
        return -1;
    }

    private static boolean isDivisibleInList(int i, List<Integer> primes) {
        return primes.parallelStream().anyMatch(x -> i % x == 0);
    }

    public static void main(String[] args) {
        System.out.println(Primes.primeFactors(98765431));
        System.out.println(pandigitalPrimeCountdown());
    }

}
