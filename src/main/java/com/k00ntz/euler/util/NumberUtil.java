package com.k00ntz.euler.util;

import java.util.ArrayList;
import java.util.List;

public class NumberUtil {

    public static List<Integer> getDigits(int i) {
        List<Integer> digits = new ArrayList<>();
        for (char c : ("" + i).toCharArray()) {
            digits.add(c - '0');
        }
        return digits;
    }
}
