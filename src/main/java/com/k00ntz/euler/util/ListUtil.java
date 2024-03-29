package com.k00ntz.euler.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtil {

    public static <T> Map<T, List<Integer>> groupToIndex(List<T> list){
        Map<T, List<Integer>> outputMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            T t = list.get(i);
            List<Integer> value = outputMap.getOrDefault(t, new ArrayList<>());
            value.add(i);
            outputMap.put(t, value);
        }
        return outputMap;
    }

    public static <T> Set<Set<T>> powerSet(Set<T> inputCollection) {
        Set<Set<T>> outputSet = new HashSet<>();
        if(inputCollection == null || inputCollection.isEmpty()){
            outputSet.add(new HashSet<>());
        }
        else if(inputCollection.size() == 1){
            outputSet.add(new HashSet<>(inputCollection));
        } else {
            for (T t :
                    inputCollection) {
                outputSet.addAll(powerSet(minus(inputCollection, t)));
                for (Set<T> s :
                        new HashSet<>(outputSet)) {
                    Set<T> anotherSet = new HashSet<>(s);
                    s.add(t);
                    outputSet.add(anotherSet);
                }
            }
        }
        return outputSet;
    }

    public static <T> Collection<T> drop(Collection<T> coll, int n){
        Collection<T> outputColl = new ArrayList<>();
        for (T t : coll) {
            if(n > 0) n--;
            else outputColl.add(t);
        }
        return outputColl;
    }

    public static <T> Set<T> minus(Set<T> input, T t){
        Set<T> outputSet = new HashSet<>(input);
        outputSet.remove(t);
        return outputSet;
    }

    public static <T> T last(List<T> list) {
        if (list == null || list.isEmpty()) return null;
        else return list.get(list.size() - 1);
    }

    public static <T extends Object & Comparable<? super T>> T maxOrNull(Collection<? extends T> ts) {
        if (ts == null) return null;
        else return Collections.max(ts);
    }

    public static int sum(List<Integer> list) {
        return list.stream().reduce(Integer::sum).orElse(Integer.MIN_VALUE);
    }

    /**
     * assumes list is sorted ascending
     *
     * @param list
     * @param i
     * @return
     */
    public static int nextIndexGreaterThan(List<Integer> list, int i) {
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) > i) return j;
        }
        return list.size();
    }

    public static int maxSumLessThan(List<Integer> list, int max) {
        int maxSum = 0;
        for (int j = 0; j < list.size(); j++) {
            maxSum += list.get(j);
            if (maxSum > max) return j;
        }
        return list.size();
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
