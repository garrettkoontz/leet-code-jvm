package com.k00ntz.euler.util;

import java.util.*;
import java.util.stream.Collectors;

public class Pandigital {

    public static Set<Integer> positiveInts = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    public static Set<Integer> allInts = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    public static Set<Long> allLongs = allInts.stream().mapToLong(x -> (long) x).boxed().collect(Collectors.toSet());

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
            if (positiveInts.containsAll(digits)) {
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

    public static List<Long> generateXDigitLongs(long x, Set<Long> digitSet) {
        List<Long> longs = Collections.synchronizedList(new ArrayList<>());
        if (x == 1)
            return digitSet.stream().mapToLong(y -> y).boxed().collect(Collectors.toList());
        digitSet.parallelStream().forEach(digit ->
                longs.addAll(prepend((long) digit, generateXDigitLongs(x - 1L, new HashSet<Long>(digitSet) {
                    {
                        this.remove(digit);
                    }
                })))
        );
        return longs;
    }

    public static List<Integer> prepend(int i, List<Integer> ints) {
        List<Integer> list = new ArrayList<>();
        for (int anInt : ints) {
            list.add(Integer.parseInt("" + i + anInt));
        }
        return list;
    }

    public static List<Long> prepend(long i, List<Long> ints) {
        List<Long> list = new ArrayList<>();
        for (long anInt : ints) {
            list.add(Long.parseLong("" + i + anInt));
        }
        return list;
    }
}
