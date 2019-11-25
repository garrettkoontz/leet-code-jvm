package com.k00ntz.euler;

import com.k00ntz.euler.util.Primes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * The first two consecutive numbers to have two distinct prime factors are:
 * <p>
 * 14 = 2 × 7
 * 15 = 3 × 5
 * <p>
 * The first three consecutive numbers to have three distinct prime factors are:
 * <p>
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 * <p>
 * Find the first four consecutive integers to have four distinct prime factors each. What is the first of these numbers?
 */
public class DistinctPrimeFactors47 {

    private static List<Integer> hasXDistinctPrimeFactorsConsecutive(int i) {
        List<Integer> resultList = new ArrayList<>();
        int j = 1;
        while (resultList.size() < i) {
            if (new HashSet<>(Primes.primeFactors(++j)).size() == i) {
                resultList.add(j);
            } else {
                resultList = new ArrayList<>();
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(hasXDistinctPrimeFactorsConsecutive(2));
        System.out.println(hasXDistinctPrimeFactorsConsecutive(3));
        System.out.println(hasXDistinctPrimeFactorsConsecutive(4));
    }
}
