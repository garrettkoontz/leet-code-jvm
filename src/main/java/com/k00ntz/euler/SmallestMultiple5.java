package com.k00ntz.euler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

import static com.k00ntz.euler.util.ListUtil.groupBy;
import static com.k00ntz.euler.util.Primes.primeFactors;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class SmallestMultiple5 {

    public static long smallestMultiple(int[] divisors) {
        Map<Integer, Integer> maxFactors = new HashMap<>();
        for (int i : divisors) {
            Map<Integer, List<Integer>> factors = groupBy(primeFactors(i), Function.identity());
            factors.forEach((k, v) -> {
                Integer currentVal = maxFactors.getOrDefault(k, 0);
                maxFactors.put(k, Math.max(currentVal, v.size()));
            });
        }
        int i = 1;
        for (Map.Entry<Integer, Integer> e : maxFactors.entrySet()) {
            i *= Math.pow(e.getKey(), e.getValue());
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(smallestMultiple(IntStream.rangeClosed(1, 10).toArray()));
        System.out.println(smallestMultiple(IntStream.rangeClosed(1, 20).toArray()));
    }
}
