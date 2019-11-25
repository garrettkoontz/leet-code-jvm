package com.k00ntz.euler;

import com.k00ntz.euler.util.Primes;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

/**
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 * <p>
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * <p>
 * It turns out that the conjecture was false.
 * <p>
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */
public class GoldbachsOtherConjecture46 {

    private static final int MAX_DOUBLE_SQAURE = 100;
    private static final int MAX_PRIME = MAX_DOUBLE_SQAURE * MAX_DOUBLE_SQAURE * 2;

    private static Set<Long> doubleSquares = IntStream.range(1, MAX_DOUBLE_SQAURE).mapToLong(x -> 2 * x * x).boxed().collect(Collectors.toSet());

    private static List<Integer> primes = Primes.segmentedSieve(MAX_PRIME);

    private static boolean isGoldbached(int i) {
        return primes.stream().filter(x -> x < i).anyMatch(x -> doubleSquares.contains((long) i - x));
    }

    public static Set<Integer> isntGoldbached(int max) {
        Set<Long> doubleSquares = IntStream.range(1, (int) floor(sqrt(max / 2)))
                .mapToLong(x -> 2 * x * x).boxed().collect(Collectors.toSet());
        List<Integer> primes = Primes.segmentedSieve(max);
        Set<Integer> composites = IntStream.rangeClosed(9, max)
                .filter(i -> i % 2 != 0 && !primes.contains(i)).boxed().collect(Collectors.toSet());
        for (int p :
                primes) {
            for (long ds :
                    doubleSquares) {
                composites.remove((int) (p + ds));
            }
        }
        return composites;
    }

    public static void main(String[] args) {
        System.out.println(isGoldbached(9));
        System.out.println(isGoldbached(15));
        System.out.println(isGoldbached(21));
        System.out.println(isGoldbached(25));
        System.out.println(isGoldbached(27));
        System.out.println(isGoldbached(33));
        System.out.println(Collections.min(isntGoldbached(50000)));
    }
}
