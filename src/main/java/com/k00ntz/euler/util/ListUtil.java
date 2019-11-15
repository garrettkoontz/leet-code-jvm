package com.k00ntz.euler.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtil {

    public static <T> T last(List<T> list) {
        if (list == null || list.isEmpty()) return null;
        else return list.get(list.size() - 1);
    }

    public static <K, T> Map<K, List<T>> groupBy(List<T> list, Function<T, K> keyFunction) {
        return list.stream().collect(Collectors.groupingBy(keyFunction));
    }

    public static int sum(Collection<Integer> list) {
        return list.stream().reduce(Integer::sum).orElse(0);
    }
}
