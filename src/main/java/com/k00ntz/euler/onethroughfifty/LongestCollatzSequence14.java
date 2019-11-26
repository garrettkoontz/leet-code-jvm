package com.k00ntz.euler.onethroughfifty;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestCollatzSequence14 {

    public static Map<Long, Long> collatzMap = new HashMap<Long, Long>() {{
        put(1L, 1L);
    }};

    public static long nextCollatz(long input) {
        return input % 2 == 0 ? input / 2 : 3 * input + 1;
    }

    public static long longestCollatz(long maxStartExclusive) {
        for (int i = 1; i < maxStartExclusive; i++) {
            lengthOfCollatzFrom(i, collatzMap);
        }
        Map.Entry<Long, Long> maxEntry = collatzMap.entrySet().stream().filter(x -> x.getKey() < maxStartExclusive)
                .max(Comparator.comparing(Map.Entry::getValue)).get();
        return maxEntry.getKey();
    }

    public static long lengthOfCollatzFrom(long i, Map<Long, Long> entries) {
        if (entries.containsKey(i)) return entries.get(i);
        else {
            long collatzLength = 1 + lengthOfCollatzFrom(nextCollatz(i), entries);
            entries.put(i, collatzLength);
            return collatzLength;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestCollatz(1000000));
    }

}
