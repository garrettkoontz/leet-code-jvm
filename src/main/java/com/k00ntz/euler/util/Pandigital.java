package com.k00ntz.euler.util;

import java.util.*;
import java.util.stream.Collectors;

public class Pandigital {

    public static Set<Integer> allowedInts = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static boolean isPandigital(int... ints) {
        return isPandigital(Arrays.stream(ints).boxed().collect(Collectors.toList()));
    }

    public static boolean isPandigital(long i) {
        List<Integer> digits = NumberUtil.getDigits(i);
        return new ArrayList<>(digits).size() == new HashSet<>(digits).size();
    }

    public static boolean isPandigital(List<Integer> ints) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : ints) {
            List<Integer> digits = NumberUtil.getDigits(i);
            if (allowedInts.containsAll(digits)) {
                list.addAll(digits);
                set.addAll(digits);
                if (list.size() != set.size()) return false;
            } else return false;
        }
        return true;
    }

    public static List<Integer> generateXDigitNumbers(int x, Set<Integer> digitSet) {
        List<Integer> ints = Collections.synchronizedList(new ArrayList<>());
        if (x == 1)
            return new ArrayList<>(digitSet);
        digitSet.parallelStream().forEach(digit ->
                ints.addAll(prepend(digit, generateXDigitNumbers(x - 1, new HashSet<Integer>(digitSet) {
                    {
                        this.remove(digit);
                    }
                })))
        );
        return ints;
    }

    public static List<Integer> prepend(int i, List<Integer> ints) {
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < ints.size(); j++) {
            list.add(Integer.parseInt("" + i + ints.get(j)));
        }
        return list;
    }
}
