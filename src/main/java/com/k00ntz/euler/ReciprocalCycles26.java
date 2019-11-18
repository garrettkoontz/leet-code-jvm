package com.k00ntz.euler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to
 * 10 are given:
 * <p>
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring
 * cycle.
 * <p>
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */
public class ReciprocalCycles26 {

    private static int representationLimit = 100;

    public static int findFractionalCycleLength(int denominator) {
        List<Integer> representation = new ArrayList<>();
        int i = -1;
        int numer = 10;
        Map<Integer, Integer> ints = new HashMap<>();
        while (numer != 0) {
            i++;
            int nextVal = numer / denominator;
            int nextNumer = (numer % denominator) * 10;
            representation.add(nextVal);
            if (ints.containsKey(nextNumer)) {
                return i - ints.get(nextNumer);
            } else {
                ints.put(nextNumer, i);
            }
            numer = nextNumer;
        }
        return -1;
    }

    public static void main(String[] args) {
        int max = 0;
        int idx = -1;
        for (int i = 2; i < 1000; i++) {
            int cycleLength = findFractionalCycleLength(i);
            if (cycleLength > max) {
                idx = i;
                max = cycleLength;
            }
        }
        System.out.println(idx);
    }
}
