package com.k00ntz.euler.onethroughfifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * <p>
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * <p>
 * That is, 3 + 7 + 4 + 9 = 23.
 * <p>
 * Find the maximum total from top to bottom of the triangle below:
 * <p>
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 */
public class MaximumPathSum18 {

    private static List<List<Integer>> pyramid = Arrays.asList(
            Arrays.asList(75),
            Arrays.asList(95, 64),
            Arrays.asList(17, 47, 82),
            Arrays.asList(18, 35, 87, 10),
            Arrays.asList(20, 4, 82, 47, 65),
            Arrays.asList(19, 1, 23, 75, 3, 34),
            Arrays.asList(88, 2, 77, 73, 7, 63, 67),
            Arrays.asList(99, 65, 4, 28, 6, 16, 70, 92),
            Arrays.asList(41, 41, 26, 56, 83, 40, 80, 70, 33),
            Arrays.asList(41, 48, 72, 33, 47, 32, 37, 16, 94, 29),
            Arrays.asList(53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14),
            Arrays.asList(70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57),
            Arrays.asList(91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48),
            Arrays.asList(63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31),
            Arrays.asList(4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23)
    );

    public static int maxTotal(List<List<Integer>> pyramid) {
        int j = 2;
        List<Integer> lower = new ArrayList<>(pyramid.get(pyramid.size() - 1));
        while (j <= pyramid.size()) {
            List<Integer> upper = new ArrayList<>(pyramid.get(pyramid.size() - j++));
            lower = maxPath(upper, lower);
        }
        return lower.get(0);
    }

    public static List<Integer> maxPath(List<Integer> upper, List<Integer> lower) {
        List<Integer> sumRow = new ArrayList<>(upper);
        for (int i = 0; i < sumRow.size(); i++) {
            sumRow.set(i, upper.get(i) + Math.max(lower.get(i), lower.get(i + 1)));
        }
        return sumRow;
    }

    public static void main(String[] args) {
        System.out.println(maxTotal(pyramid));
    }
}
