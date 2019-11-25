package com.k00ntz.euler;

import com.k00ntz.euler.util.NumberUtil;
import com.k00ntz.euler.util.Primes;

import java.util.*;
import java.util.stream.Collectors;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 * <p>
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there is
 * one other 4-digit increasing sequence.
 * <p>
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class PrimePermutations49 {

    private static boolean isPermutation(int x, int y) {
        if (x == y) return false;
        List<Integer> xDigits = NumberUtil.getDigits(x);
        List<Integer> yDigits = NumberUtil.getDigits(y);
        Collections.sort(xDigits);
        Collections.sort(yDigits);
        return xDigits.equals(yDigits);
    }

    private static Set<List<Integer>> fourDigitSequence() {
        List<Integer> primes = Primes.segmentedSieve(10000);
        primes.removeIf(x -> x < 1000);
        List<List<Integer>> resultList = new ArrayList<>();
        for (int p : primes) {
            List<Integer> primePermutiations = primes.stream().filter(x -> isPermutation(p, x)).collect(Collectors.toList());
            if (3L <= primePermutiations.size()) {
                resultList.add(primePermutiations);
            }
        }
        Set<List<Integer>> finalResult = new HashSet<>();
        for (List<Integer> perm :
                resultList) {
            Collections.sort(perm);
            for (int i = 0; i < perm.size(); i++) {
                for (int j = i + 1; j < perm.size(); j++) {
                    if (perm.get(i) == 1487)
                        System.out.println("found it");
                    if (perm.indexOf(perm.get(j) + perm.get(j) - perm.get(i)) != -1)
                        finalResult.add(Arrays.asList(perm.get(i), perm.get(j), perm.get(j) + perm.get(j) - perm.get(i)));
                }
            }
        }
        return finalResult;
    }

    public static void main(String[] args) {
        System.out.println(fourDigitSequence());
    }
}
