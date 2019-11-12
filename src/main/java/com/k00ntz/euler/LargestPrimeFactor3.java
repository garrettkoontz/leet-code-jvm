package com.k00ntz.euler;

import java.util.Collections;

import static com.k00ntz.euler.util.ListUtil.last;
import static com.k00ntz.euler.util.Primes.primeFactors;


/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class LargestPrimeFactor3 {

    public static void main(String[] args) {
        System.out.println(last(primeFactors(13195L)));
        System.out.println(last(primeFactors(600851475143L)));
    }
}
