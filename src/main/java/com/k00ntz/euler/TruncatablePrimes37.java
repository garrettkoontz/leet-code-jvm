package com.k00ntz.euler;

import com.k00ntz.euler.util.Primes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from
 * left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.
 * <p>
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * <p>
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class TruncatablePrimes37 {


    private static List<Integer> primesList = Primes.segmentedSieve(1000000);
    private static Set<Integer> primesSet = new HashSet<>(primesList);

    public static boolean isTruncatablePrime(long i) {
        long lr = i;
        for (int j = 0; j < Math.log10(i); j++) {
            if (primesSet.contains((int) lr)) {
                lr /= 10;
            } else return false;
        }

        long rl = i;
        for (int j = 0; j < Math.log10(i); j++) {
            if (primesSet.contains((int) rl)) {
                int powerOfTen = (int) Math.pow(10, (int) Math.log10(i) - j);
                rl %= powerOfTen;
            } else return false;
        }
        return true;
    }

    public static List<Integer> findTruncatablePrimes() {
        List<Integer> answer = new ArrayList<>();
        int firstIndex = primesList.indexOf(11);
        for (int i = firstIndex; i < primesList.size(); i++) {
            if (isTruncatablePrime(primesList.get(i))) {
                answer.add(primesList.get(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(isTruncatablePrime(3797));
        System.out.println(findTruncatablePrimes().stream().mapToInt(x -> x).sum());
    }
}
