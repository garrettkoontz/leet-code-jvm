package com.k00ntz.euler;

import com.k00ntz.euler.util.ListUtil;
import com.k00ntz.euler.util.NumberUtil;
import com.k00ntz.euler.util.Primes;

import java.util.*;
import java.util.stream.Collectors;

import static com.k00ntz.euler.util.ListUtil.groupToIndex;
import static com.k00ntz.euler.util.ListUtil.last;
import static java.lang.Math.*;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values: 13, 23, 43,
 * 53, 73, and 83, are all prime.
 * <p>
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having
 * seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773, and
 * 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.
 * <p>
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit,
 * is part of an eight prime value family.
 */
public class PrimeDigitReplacements51 {


    /*
    Or, we could do a string distance calc...
     */
    private static int replaceDigit(int p, int star, Set<Integer> idxs) {
        List<Integer> digits = NumberUtil.getDigits(p);
        for (int i :
                idxs) {
            digits.set(i, star);
        }
        return (int) NumberUtil.getNumber(digits);
    }

    private static List<Integer> replaceDigitsWithEachDigit(int p, Set<Integer> stars, Set<Integer> idxs) {
        return stars.stream().map(s -> replaceDigit(p, s, idxs)).collect(Collectors.toList());
    }

    private static Map<Set<Integer>, List<Integer>> replaceDigitMap(int p, int minSize, Set<Integer> primes) {
        Map<Set<Integer>, List<Integer>> outputMap = new HashMap<>();
        List<Integer> ints = NumberUtil.range(0, 10);
        Set<Integer> intsSet = new HashSet<>(ints);
        Map<Integer, List<Integer>> digitIndexMap = groupToIndex(NumberUtil.getDigits(p));
        int min = (int) pow(10, floor(log10(p)));
        for (Map.Entry<Integer, List<Integer>> e : digitIndexMap.entrySet()) {
            Set<Set<Integer>> powerSet = ListUtil.powerSet(new HashSet<>(e.getValue()));
            powerSet.parallelStream().forEach(idxs -> {
                List<Integer> digits = replaceDigitsWithEachDigit(p, intsSet, idxs);
                digits.removeIf(y -> !primes.contains(y) || y < min);
                if(digits.size() >= minSize)
                    outputMap.put(idxs,digits);
            });
        }
        return outputMap;
    }

    public static List<Integer> searchForMinSize(int minSize, int startHint){
        long startTime = System.currentTimeMillis();
        List<Integer> primes = Primes.segmentedSieve(startHint * 2);
        int idx = primes.indexOf(startHint) - 1;
        while(true){
            ++idx;
            if(idx == primes.size()){
                primes = Primes.segmentedSieve(2 * last(primes),primes);
            }
            int p = primes.get(idx);
            Set<Integer> primesSet = new HashSet<>(primes);
            Map<Set<Integer>, List<Integer>> map = replaceDigitMap(p, minSize, primesSet);
            if(!map.isEmpty()){
                return map.entrySet().stream().max(Comparator.comparingLong(e -> e.getValue().size()))
                        .get().getValue();
            }
            if(System.currentTimeMillis() - startTime > 60000) return Collections.singletonList(primes.get(idx));
        }
    }

    public static void main(String[] args) {
        System.out.println(searchForMinSize(6, 11));
        System.out.println(searchForMinSize(7, 83));
        System.out.println(searchForMinSize(8, 483787)); // 356113
    }

}
