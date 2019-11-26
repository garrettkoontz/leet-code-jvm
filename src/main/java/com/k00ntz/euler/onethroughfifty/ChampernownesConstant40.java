package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.NumberUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 * <p>
 * 0.123456789101112131415161718192021...
 * <p>
 * It can be seen that the 12th digit of the fractional part is 1.
 * <p>
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 * <p>
 * d`1 × d`10 × d`100 × d`1000 × d`10000 × d`100000 × d`1000000
 */
public class ChampernownesConstant40 {

    public static List<Integer> getDigitAt(int... idxs) {
        Arrays.sort(idxs);
        int max = idxs[idxs.length - 1];
        List<Integer> chConsts = new ArrayList<>();
        for (int i = 1; i < max; i++) {
            chConsts.addAll(NumberUtil.getDigits(i));
            if (i % 10 == 0 && chConsts.size() > max) break;
        }
        List<Integer> result = new ArrayList<>();
        for (int idx : idxs) {
            result.add(chConsts.get(idx - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getDigitAt(12));
        System.out.println(getDigitAt(1, 10, 100, 1000, 10000, 100000, 1000000)
                .stream().reduce((a, b) -> a * b).orElse(-1));
    }
}
