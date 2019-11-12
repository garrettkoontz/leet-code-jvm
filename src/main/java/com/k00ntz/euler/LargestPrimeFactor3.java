package com.k00ntz.euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.k00ntz.euler.util.Primes.sieveOfEratosthenes;

public class LargestPrimeFactor3 {

    public static List<Integer> primeFactors(long l) {
        List<Integer> primeFactors = new ArrayList<>();
        List<Integer> primes = sieveOfEratosthenes((int) Math.ceil(Math.sqrt(l)));
        outer:
        while (l != 1) {

            for (Integer p : primes) {
                if (l % p == 0) {
                    primeFactors.add(p);
                    l /= p;
                    continue outer;
                }
            }
            primeFactors.add((int) l);
            l /= l;
        }
        return primeFactors;
    }

    public static void main(String[] args) {
        System.out.println(Collections.max(primeFactors(13195L)));
        System.out.println(Collections.max(primeFactors(600851475143L)));
    }
}
