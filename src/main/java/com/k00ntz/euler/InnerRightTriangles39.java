package com.k00ntz.euler;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three
 * solutions for p = 120.
 * <p>
 * {20,48,52}, {24,45,51}, {30,40,50}
 * <p>
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class InnerRightTriangles39 {

    public static boolean hasIntegerThird(int a, int b) {
        double c = sqrt(a * a + b * b);
        return Double.compare(c, floor(c)) == 0;
    }

    public static int countTriangles(int p) {
        Set<Integer> triangle = new HashSet<>();
        for (int i = 1; i < p - 2; i++) {
            for (int j = 1; j < p - i; j++) {
                if ((double) p - i - j == sqrt(i * i + j * j)) {
                    triangle.add(i);
                    triangle.add(j);
                    triangle.add(p - i - j);
                }
            }
        }
        return triangle.size() / 3;
    }

    public static int maxP(int maxInclusive) {
        int maxP = -1;
        int maxC = -1;
        for (int i = 3; i <= maxInclusive; i++) {
            int c = countTriangles(i);
            if (maxC < c) {
                maxP = i;
                maxC = c;
            }
        }
        return maxP;
    }

    public static void main(String[] args) {
        System.out.println(countTriangles(120));
        System.out.println(maxP(1000));
    }
}
