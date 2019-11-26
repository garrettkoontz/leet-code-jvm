package com.k00ntz.euler.onethroughfifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.k00ntz.euler.util.Pandigital.*;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * <p>
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated
 * product of 192 and (1,2,3)
 * <p>
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645,
 * which is the concatenated product of 9 and (1,2,3,4,5).
 * <p>
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with
 * (1,2, ... , n) where n > 1?
 */
public class PandigitalMultiples38 {

    public static Long concatenatedMultiple(int i, int n) {
        return Long.parseLong(IntStream.rangeClosed(1, n).mapToObj(x -> "" + (i * x)).collect(Collectors.joining()));
    }

    public static boolean isPandigitalMultiple(int i, int n) {
        return isPandigital(concatenatedMultiple(i, n));
    }

    public static List<Long> generatePossiblePandigitalMultiples() {
        List<Long> panDigitals = new ArrayList<>();
        Set<Long> panDigitalInts = generateXDigitNumbers(9, positiveInts)
                .stream().mapToLong(x -> (long) x).boxed().collect(Collectors.toSet());
        for (int i = 1; i < 10; i++) {
            long test = concatenatedMultiple(i, 5);
            if (panDigitalInts.contains(test)) {
                panDigitals.add(test);
            }
        }
        for (Integer pd : generateXDigitNumbers(3, positiveInts)) {
            long test = concatenatedMultiple(pd, 3);
            if (panDigitalInts.contains(test)) {
                panDigitals.add(test);
            }
        }
        for (Integer pd : generateXDigitNumbers(4, positiveInts)) {
            long test = concatenatedMultiple(pd, 2);
            if (panDigitalInts.contains(test)) {
                panDigitals.add(test);
            }
        }
        return panDigitals;
    }

    public static void main(String[] args) {
        System.out.println(isPandigitalMultiple(192, 3));
        System.out.println(isPandigitalMultiple(9, 5));
        System.out.println(Collections.max(generatePossiblePandigitalMultiples()));
    }

}
