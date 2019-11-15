package com.k00ntz.euler;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly
 * 6 routes to the bottom right corner.
 * <p>
 * How many such routes are there through a 20×20 grid?
 */
public class LatticePaths15 {

    public static long latticeSquareRoutesCount(int size) {
        long pathLength = 1;
        for (int i = 1; i <= size; i++) {
            pathLength = pathLength * (size + i) / i;
        }
        return pathLength;
    }

    public static void main(String[] args) {
        System.out.println(latticeSquareRoutesCount(2));
        System.out.println(latticeSquareRoutesCount(3));
        System.out.println(latticeSquareRoutesCount(20));
    }
}
