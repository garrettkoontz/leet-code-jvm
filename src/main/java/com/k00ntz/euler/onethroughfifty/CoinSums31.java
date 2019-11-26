package com.k00ntz.euler.onethroughfifty;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * <p>
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * <p>
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class CoinSums31 {

    enum Coin {
        P1(1),
        P2(2),
        P5(5),
        P10(10),
        P20(20),
        P50(50),
        L1(100),
        L2(200);

        int value;

        Coin(int value) {
            this.value = value;
        }
    }

    private static Coin[] coins = Coin.values();

    private static EnumMap<Coin, Map<Integer, Integer>> memo = new EnumMap<>(Coin.class);

    private static Map<Integer, Integer> emptyMap = Collections.emptyMap();

    /**
     * https://andrew.neitsch.ca/publications/m496pres1.nb.pdf
     *
     * @param n
     * @param k
     * @return
     */
    public static int numberOfWaysToMakeChange(int n, int k) {
        if (n < 0 || k >= coins.length) return 0;
        if (n == 0) return 1;
        Coin coinK = coins[k];
        if (memo.getOrDefault(coinK, emptyMap).containsKey(n))
            return memo.get(coinK).get(n);
        else {
            int value = numberOfWaysToMakeChange(n, k + 1) + numberOfWaysToMakeChange(n - coinK.value, k);
            Map<Integer, Integer> oldVal = memo.getOrDefault(coinK, new HashMap<>());
            oldVal.put(n, value);
            memo.put(coinK, oldVal);
            return value;
        }
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(200, 0));
    }
}
