package com.k00ntz.euler;

import com.k00ntz.euler.util.ListUtil;
import com.k00ntz.euler.util.NumberUtil;

import java.util.*;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example,
 * the 5-digit number, 15234, is 1 through 5 pandigital.
 * <p>
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1
 * through 9 pandigital.
 * <p>
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * <p>
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class PandigitalProducts32 {

    private static Set<Integer> allowedInts = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static boolean isPandigital(int... ints) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i :
                ints) {
            List<Integer> digits = NumberUtil.getDigits(i);
            if (allowedInts.containsAll(digits)) {
                list.addAll(digits);
                set.addAll(digits);
                if (list.size() != set.size()) return false;
            } else return false;
        }
        return true;
    }

    public static Set<Integer> findPandigitalProducts(Set<Integer> ints) {
        Set<Integer> pandigitalProducts = new HashSet<>();
        List<Integer> five = generateXDigitNumbers(5, ints);
        for (int j :
                five) {
            int firstTwo = j / 1000;
            int secondThree = j % 1000;
            int product = firstTwo * secondThree;
            if (isPandigital(firstTwo, secondThree, product)) {
                pandigitalProducts.add(product);
            }
            int firstOne = j / 10000;
            int secondFour = j % 10000;
            int product2 = firstOne * secondFour;
            if (isPandigital(firstOne, secondFour, product2)) {
                pandigitalProducts.add(product2);
            }
        }
        return pandigitalProducts;
    }

    public static List<Integer> generateXDigitNumbers(int x, Set<Integer> digitSet) {
        List<Integer> ints = new ArrayList<>();
        if (x == 1)
            return new ArrayList<>(digitSet);
        for (Integer digit : digitSet) {
            ints.addAll(prepend(digit, generateXDigitNumbers(x - 1, new HashSet<Integer>(digitSet) {
                {
                    this.remove(digit);
                }
            })));
        }
        return ints;
    }

    public static List<Integer> prepend(int i, List<Integer> ints) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < ints.size(); j++) {
            list.add(Integer.parseInt("" + i + ints.get(j)));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(isPandigital(39, 186, 7254));
//        System.out.println("products: " + findPandigitalProducts(allowedInts));
        System.out.println(ListUtil.sum(findPandigitalProducts(allowedInts)));
    }

}
