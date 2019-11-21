package com.k00ntz.euler;

import com.k00ntz.euler.util.ListUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.k00ntz.euler.util.Pandigital.*;

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

    public static void main(String[] args) {
        System.out.println(isPandigital(39, 186, 7254));
        System.out.println(ListUtil.sum(findPandigitalProducts(allowedInts)));
    }

}
