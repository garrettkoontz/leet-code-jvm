package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.NumberUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The decimal number, 585 = 1001001001`2 (binary), is palindromic in both bases.
 * <p>
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * <p>
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class DoubleBasePalindromes36 {

    public static boolean isDoubleBasePalindrome(int i) {
        return NumberUtil.isPalindrome(i) && NumberUtil.isPalindrome(Integer.toBinaryString(i));
    }

    public static List<Integer> doublePalindromeIntsLessThan(int maxExclusive) {
        return IntStream.range(0, maxExclusive).filter(DoubleBasePalindromes36::isDoubleBasePalindrome).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(doublePalindromeIntsLessThan(1000000).stream().mapToInt(x -> x).sum());
        System.out.println(isDoubleBasePalindrome(585));
    }

}
