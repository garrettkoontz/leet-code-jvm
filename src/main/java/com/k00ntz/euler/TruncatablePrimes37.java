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


    private static List<Integer> primesList = Primes.segmentedSieve(10);
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
        int total = 11;
        List<Integer> answer = new ArrayList<>();
        int segment = 10000;
        int last = 11;
        while (answer.size() < total) {
            int nextIndex = primesList.size();
            last = primesList.get(nextIndex - 1);
            primesList = Primes.segmentedSieve(last + segment, primesList);
            primesSet = new HashSet<>(primesList);
            for (int i = nextIndex; i < primesList.size(); i++) {
                if (primesList.get(i) == 3797) System.out.println("got to 3797");
                if (isTruncatablePrime(primesList.get(i))) {
                    System.out.println("found " + primesList.get(i));
                    answer.add(primesList.get(i));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(findTruncatablePrimes());
    }
}
