package com.k00ntz.euler;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class LargestPalindromeProduct4 {

    static int maxPalindrome(int min, int max) {
        int currentMaxPalindrome = Integer.MIN_VALUE;
        for (int i = max; i >= min; i--) {
            for (int j = max; j >= min; j--) {
                int t = i * j;
                if (t > currentMaxPalindrome) {
                    if (isPalindrome(t))
                        currentMaxPalindrome = t;
                }
            }
        }
        return currentMaxPalindrome;
    }

    static boolean isPalindrome(int i) {
        double log = Math.floor(Math.log10(i));
        int highIndex = (int) Math.pow(10, log);
        int lowIndex = 1;
        while (highIndex >= lowIndex) {
            int modHigh = (i % (highIndex * 10)) / highIndex;
            int modLow = (i / lowIndex) % 10;
            if (modHigh != modLow) return false;
            highIndex /= 10;
            lowIndex *= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(9009));
        System.out.println(maxPalindrome(10, 99));
        System.out.println(maxPalindrome(100, 999));
    }
}
