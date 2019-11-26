package com.k00ntz.euler.onethroughfifty;

import com.k00ntz.euler.util.Primes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.k00ntz.euler.util.ListUtil.maxSumLessThan;
import static com.k00ntz.euler.util.ListUtil.sum;

/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * <p>
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * <p>
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 * <p>
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class ConsecutivePrimeSum50 {


    private static int maxConsecutivePrimeSum(int max) {
        List<Integer> primes = Primes.segmentedSieve(max);
        Set<Integer> primesSet = new HashSet<>(primes);
        int maxLength = 0;
        int maxSum = 0;
        outer:
        for (int i = 0; i < primes.size(); i++) {
            int maxIndex = maxSumLessThan(primes, max);
            for (int j = maxIndex; j > i + maxLength; j--) {
                int sum = sum(primes.subList(i, j));
                if (primesSet.contains(sum)) {
                    if (j - i > maxLength) {
                        maxLength = j - i;
                        maxSum = sum;
                        continue outer;
                    }
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutivePrimeSum(100));
        System.out.println(maxConsecutivePrimeSum(1000));
        System.out.println(maxConsecutivePrimeSum(1000000));
    }

}
