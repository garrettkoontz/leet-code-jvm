package com.k00ntz.euler;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 52.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class SpecialPythagoreanTriplet9 {

    private static boolean isPythagoreanTriple(int x, int y, int z) {
        if (x == y && y == z) return false;
        int c = Math.max(x, Math.max(y, z));
        int a = Math.min(x, Math.min(y, z));
        int b = x + y + z - c - a;
        return (int) (Math.pow(a, 2) + Math.pow(b, 2)) == (int) Math.pow(c, 2);
    }

    public static long findPythagoreanTripleAtSum(int sum) {
        for (int i = 1; i < sum - 1; i++) {
            for (int j = 1; j < sum - i - 1; j++) {
                int z = sum - i - j;
                if(isPythagoreanTriple(i, j, z)) return i * j * z;
            }
        }
        return -1L;
    }

    public static void main(String[] args) {
        System.out.println(isPythagoreanTriple(3, 4, 5));
        System.out.println(findPythagoreanTripleAtSum(3 + 4 + 5));
        System.out.println(findPythagoreanTripleAtSum(1000));
    }
}
