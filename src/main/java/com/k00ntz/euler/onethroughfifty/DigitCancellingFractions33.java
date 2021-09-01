package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.NumberUtil;
import com.k00ntz.euler.util.Pair;

import java.util.ArrayList;
import java.util.List;

import static com.k00ntz.euler.util.NumberUtil.fractionReduction;

/**
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
 * incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 * <p>
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * <p>
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two
 * digits in the numerator and denominator.
 * <p>
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class DigitCancellingFractions33 {

    private static boolean isDigitCancellingFraction(int num, int denom) {
        List<Integer> numDigits = NumberUtil.getDigits(num);
        List<Integer> denomDigits = NumberUtil.getDigits(denom);
        numDigits.removeAll(NumberUtil.getDigits(denom));
        denomDigits.removeAll(NumberUtil.getDigits(num));
        if (numDigits.size() != 1 || denomDigits.size() != 1) return false;
        return Double.valueOf((double) num / (double) denom)
                .equals((double) numDigits.get(0) / (double) denomDigits.get(0));
    }

    public static List<Pair<Integer, Integer>> findDigitCancellingFractions() {
        List<Pair<Integer, Integer>> digitCancelled = new ArrayList<>();
        for (int i = 11; i < 100; i++) {
            if (i % 10 == 0) continue;
            for (int j = i + 1; j < 100; j++) {
                if (isDigitCancellingFraction(i, j)) digitCancelled.add(new Pair<>(i, j));
            }
        }
        return digitCancelled;
    }

    public static Pair<Integer, Integer> reduceProduct(List<Pair<Integer, Integer>> pairs) {
        Integer num = pairs.stream().mapToInt(x -> x._1).reduce((a, b) -> a * b).orElse(0);
        Integer denom = pairs.stream().mapToInt(x -> x._2).reduce((a, b) -> a * b).orElse(0);
        return fractionReduction(new Pair<>(num, denom));
    }

    public static void main(String[] args) {
        System.out.println(isDigitCancellingFraction(49, 98));
        System.out.println(reduceProduct(findDigitCancellingFractions()));
    }
}
