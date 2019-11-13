package com.k00ntz.euler;

import com.k00ntz.euler.util.PrimeUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class SmallestMultiple {
    public static void main(String[] args) {
        System.out.println(smallestMultiple(IntStream.rangeClosed(1, 10)));
        System.out.println(smallestMultiple(IntStream.rangeClosed(1, 20)));
    }


    private static int smallestMultiple(IntStream range) {
        Map<Long, Integer> maxFactorMap = maxPrimeFactorMap(range.toArray());
        int smallestMultiple = 1;
        for (Map.Entry<Long, Integer> factorEntry : maxFactorMap.entrySet()) {
            smallestMultiple *= (int) Math.pow(factorEntry.getKey(), factorEntry.getValue());
        }
        return smallestMultiple;
    }

    private static Map<Long, Integer> maxPrimeFactorMap(int[] numbers) {
        List<Map<Long, Integer>> primeFactorMaps = new ArrayList<>();
        for (int number : numbers) {
            primeFactorMaps.add(PrimeUtils.getPrimeFactorMap(number));
        }
        final Map<Long, Integer> returnMap = new HashMap<>();
        for (Map<Long, Integer> mp : primeFactorMaps) {
            mp.forEach((key, value) ->
                    returnMap.merge(key, value, (v1, v2) -> v1 > v2 ? v1 : v2));
        }
        return returnMap;
    }

}
