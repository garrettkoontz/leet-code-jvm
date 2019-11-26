package com.k00ntz.euler.onethroughfifty;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Multiples3And51 {

    public static void main(String[] args) {
        System.out.println(sumOf3or5Multiples(1000)); //233168
    }

    public static int sumOf3or5Multiples(int limit) {
        int sum = 0;
        for (int i = 0; i < limit; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
