package com.k00ntz.euler.util;

import java.util.*;
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

    public static <T> List<T> sumToList(Collection<? extends T>... lists) {
        List<T> returnList = new ArrayList<>();
        for (Collection<? extends T> tset :
                lists) {
            returnList.addAll(tset);
        }
        return returnList;
    }

    public static <T> Set<T> sumToSet(Collection<? extends T>... lists) {
        Set<T> returnSet = new HashSet<>();
        for (Collection<? extends T> tset :
                lists) {
            returnSet.addAll(tset);
        }
        return returnSet;
    }

    public static <T> List<T> plus(List<T> list, T t) {
        List<T> outputList = new ArrayList<>(list);
        outputList.add(t);
        return outputList;
    }

    public static <T> List<T> plus(List<T> list, List<T> list2) {
        List<T> outputList = new ArrayList<>(list);
        outputList.addAll(list2);
        return outputList;
    }
}
