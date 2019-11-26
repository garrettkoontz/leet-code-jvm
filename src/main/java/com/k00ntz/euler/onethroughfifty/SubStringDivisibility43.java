package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.ListUtil;
import com.k00ntz.euler.util.NumberUtil;
import com.k00ntz.euler.util.Pandigital;

import java.util.*;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some
 * order, but it also has a rather interesting sub-string divisibility property.
 * <p>
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * <p>
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class SubStringDivisibility43 {

    static List<Integer> goodPrimes = Arrays.asList(2, 3, 5, 7, 11, 13, 17);

    public static long subList(List<Integer> panDigital, int start, int endExclusive) {
        return NumberUtil.getNumber(panDigital.subList(start, endExclusive));
    }

    public static boolean isSubstringDivisible(List<Integer> panDigital) {
        for (int i = 0; i < goodPrimes.size(); i++) {
            if (subList(panDigital, i + 1, i + 4) % goodPrimes.get(i) != 0) return false;
        }
        return true;
    }

    public static Set<Long> subStringDivisiblePandigitals() {
        List<List<Integer>> pandigitals = generateXDigitLongsList(10, Pandigital.allInts);
        Set<Long> output = new HashSet<>();
        pandigitals.parallelStream().forEach(p -> {
            if (isSubstringDivisible(p)) output.add(NumberUtil.getNumber(p));
        });
        return output;
    }

    public static List<List<Integer>> generateXDigitLongsList(int x, Set<Integer> digitSet) {
        List<List<Integer>> listList = Collections.synchronizedList(new ArrayList<>());
        if (x == 1)
            return new ArrayList<>(Arrays.asList(new ArrayList<>(digitSet)));
        digitSet.parallelStream().forEach(digit ->
                listList.addAll(addDigit(digit, generateXDigitLongsList(x - 1, new HashSet<Integer>(digitSet) {
                    {
                        this.remove(digit);
                    }
                })))
        );
        return listList;
    }

    private static List<List<Integer>> addDigit(int i, List<List<Integer>> lists) {
        List<List<Integer>> newList = new ArrayList<>();
        for (List<Integer> li :
                lists) {
            newList.add(ListUtil.plus(li, i));
        }
        return newList;
    }

    public static void main(String[] args) {
        System.out.println(isSubstringDivisible(Arrays.asList(1, 4, 0, 6, 3, 5, 7, 2, 8, 9)));
        System.out.println(subStringDivisiblePandigitals().stream().mapToLong(x -> x).sum());
    }

}
