package com.k00ntz.euler;

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * <p>
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * <p>
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * <p>
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class NumberSpiralDiagonals28 {

    public static int numberSpiralSum(int s) {
        int start = 1;
        for (int i = 3; i <= s; i += 2) {
            int range = i - 1;
            int max = i * i;
            for (int j = 0; j < 4; j++) {
                start += (max - (j * range));
            }
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(numberSpiralSum(3));
        System.out.println(numberSpiralSum(5));
        System.out.println(numberSpiralSum(1001));
    }
}
