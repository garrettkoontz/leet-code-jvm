package com.k00ntz.euler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

public class Primes {

    public static List<Integer> primeFactors(long l) {
        List<Integer> primeFactors = new ArrayList<>();
        List<Integer> primes = sieveOfEratosthenes((int) Math.ceil(Math.sqrt(l)));
        outer:
        while (l != 1) {

            for (Integer p : primes) {
                if (l % p == 0) {
                    primeFactors.add(p);
                    l /= p;
                    continue outer;
                }
            }
            primeFactors.add((int) l);
            l /= l;
        }
        return primeFactors;
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    // using simple sieve of eratosthenes. It also stores
    // found primes in vector prime[]
    public static void simpleSieve(int limit, List<Integer> prime) {
        // Create a boolean array "mark[0..n-1]" and initialize
        // all entries of it as true. A value in mark[p] will
        // finally be false if 'p' is Not a prime, else true.
        boolean[] mark = new boolean[limit + 1];

        Arrays.fill(mark, true);

        for (int p = 2; p * p < limit; p++) {
            // If p is not changed, then it is a prime
            if (mark[p]) {
                // Update all multiples of p
                for (int i = p * 2; i < limit; i += p)
                    mark[i] = false;
            }
        }

        // Print all prime numbers and store them in prime
        for (int p = 2; p < limit; p++) {
            if (mark[p]) {
                prime.add(p);
            }
        }
    }

    public static List<Integer> segmentedSieve(long n) {
        // Compute all primes smaller than or equal
        // to square root of n using simple sieve
        int limit = (int) (floor(sqrt(n)) + 1);
        List<Integer> prime = new ArrayList<>();
        simpleSieve(limit, prime);

        // Divide the range [0..n-1] in different segments
        // We have chosen segment size as sqrt(n).
        int low = limit;
        int high = 2 * limit;

        // While all segments of range [0..n-1] are not processed,
        // process one segment at a time
        while (low < n) {
            if (high >= n)
                high = (int) n;

            // To mark primes in current range. A value in mark[i]
            // will finally be false if 'i-low' is Not a prime,
            // else true.
            boolean[] mark = new boolean[limit + 1];

            Arrays.fill(mark, true);

            // Use the found primes by simpleSieve() to find
            // primes in current range
            for (Integer integer : prime) {
                // Find the minimum number in [low..high] that is
                // a multiple of prime.get(i) (divisible by prime.get(i))
                // For example, if low is 31 and prime.get(i) is 3,
                // we start with 33.
                int loLim = (int) (floor(low / integer) * integer);
                if (loLim < low)
                    loLim += integer;

                /*  Mark multiples of prime.get(i) in [low..high]:
                    We are marking j - low for j, i.e. each number
                    in range [low, high] is mapped to [0, high-low]
                    so if range is [50, 100]  marking 50 corresponds
                    to marking 0, marking 51 corresponds to 1 and
                    so on. In this way we need to allocate space only
                    for range  */
                for (int j = loLim; j < high; j += integer)
                    mark[j - low] = false;
            }
            for (int i = low; i < high; i++)
                if (mark[i - low])
                    prime.add(i);
            // Update low and high for next segment
            low = low + limit;
            high = high + limit;
        }
        return prime;
    }

}
