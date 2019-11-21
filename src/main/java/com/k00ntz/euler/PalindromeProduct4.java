package com.k00ntz.euler;

import java.util.stream.IntStream;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class PalindromeProduct4 {
    public static void main(String[] args) {
        System.out.println(new PalindromeProduct4().findMax(IntStream.rangeClosed(10, 99)));
        System.out.println(new PalindromeProduct4().findMax(IntStream.rangeClosed(100, 999)));
    }

    private int findMax(IntStream range) {
        int[] rangeArray = range.toArray();
        int max = 0;
        for (int i = rangeArray.length - 1; i >= 0; i--) {
            if (rangeArray[i] * rangeArray[rangeArray.length - 1] < max)
                return max;
            for (int j = rangeArray.length - 1; j >= 0; j--) {
                int num = rangeArray[i] * rangeArray[j];
                if (num > max) {
                    if (isPalindromeNumber(num)) max = num;
                } else {
                    j = -1;
                }
            }
        }
        return max;
    }

    private boolean isPalindromeNumber(int i) {
        String iStr = "" + i;
        for (int j = 0; j < iStr.length() / 2; j++) {
            if (iStr.charAt(j) != iStr.charAt(iStr.length() - j - 1)) return false;
        }
        return true;
    }
}
