package com.k00ntz.euler.onethroughfifty;

import java.util.function.Function;

/**
 * The sum of the squares of the first ten natural numbers is,
 * <p>
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * <p>
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class SumSquareDifference6 {

    public static int sumOfRange(int start, int end, Function<Integer, Integer> transform) {
        int s = 0;
        for (int i = start; i <= end; i++) {
            s += transform.apply(i);
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println((int)
                Math.pow(sumOfRange(1, 10, Function.identity()), 2) -
                sumOfRange(1, 10, x -> (int) Math.pow(x, 2))
        );
        System.out.println(((int) Math.pow(sumOfRange(1, 100, Function.identity()), 2) -
                sumOfRange(1, 100, x -> (int) Math.pow(x, 2)))
        );
    }
}
