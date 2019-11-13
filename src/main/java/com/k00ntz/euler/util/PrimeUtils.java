package com.k00ntz.euler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrimeUtils {

    private static List<Long> primesCache = new ArrayList<>();

    public static List<Long> generatePrimesUpTo(long num) {
        if (!primesCache.isEmpty() && primesCache.get(primesCache.size() - 1) > num)
            return primesCache.stream().filter(x -> x < num).collect(Collectors.toList());
        long startVal = 3L;
        if (!primesCache.isEmpty()) {
            startVal = primesCache.get(primesCache.size() - 1) + 1;
        } else {
            primesCache.add(2L);
        }
        for (long i = startVal; i <= num; i += 2) {
            primesCache.add(i);
        }
        int idx = 0;
        while (idx < primesCache.size()) {
            long value = primesCache.get(idx);
            primesCache = primesCache.stream().filter(x -> x % value != 0 || x == value).collect(Collectors.toList());
            idx++;
        }
        return primesCache;
    }

    public List<Long> getPrimeFactorsOf(long number) {
        List<Long> primes = PrimeUtils.generatePrimesUpTo(number);
        return primes.stream().filter(p -> number % p == 0).collect(Collectors.toList());
    }

    public static Map<Long, Integer> getPrimeFactorMap(long number) {
        List<Long> primes = PrimeUtils.generatePrimesUpTo(number);
        return primes.stream().filter(p -> number % p == 0).collect(Collectors.toMap(
                x -> x, x -> (int) (number / x)
        ));
    }
}
