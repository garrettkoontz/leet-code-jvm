package com.k00ntz.euler;

import com.k00ntz.euler.util.ListUtil;
import com.k00ntz.euler.util.NumberUtil;
import com.k00ntz.euler.util.Primes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * <p>
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * <p>
 * How many circular primes are there below one million?
 */
public class CircularPrimes35 {

    public static int rotate(int i, int p) {
        List<Integer> digits = NumberUtil.getDigits(i);
        return Integer.parseInt(ListUtil.plus(digits.subList(p, digits.size()), digits.subList(0, p))
                .stream().map(Object::toString).reduce("", (a, b) -> a + b));
    }

    public static List<Integer> findCircularPrimes(int max) {
        Set<Integer> ints = new HashSet<>(Primes.segmentedSieve(max));
        List<Integer> returnList = new ArrayList<>();
        outer:
        for (int i : ints) {
            for (int j = 1; j < Math.log10(i); j++) {
                if (!ints.contains(rotate(i, j))) continue outer;
            }
            returnList.add(i);
        }
        return returnList;
    }

    public static void main(String[] args) {
        System.out.println(findCircularPrimes(100));
        System.out.println(findCircularPrimes(1000000).size());
    }
}
