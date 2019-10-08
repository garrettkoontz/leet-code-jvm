package com.k00ntz.leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
// Stuck, DP, dp[i] = dp[i-1] + dp[i-2]
public class SolutionClimbingStairs {
    public int climbStairs(int n) {
        // This is really just a combinatorics problem: http://spartan.ac.brocku.ca/~jvrbik/MATH2P81/Lec1.pdf and
        // https://math.stackexchange.com/questions/1203251/how-many-different-permutations-are-there-of-the-sequence-of-letters-in-mississ
        int numberOfTwos = n / 2;
        int plusOne = n % 2;
        int ans = 0;
        for (int i = 0; i <= numberOfTwos; i++) {
            int iterNumberOfTwos = (numberOfTwos - i);
            int iterNumberOfOnes = (numberOfTwos - iterNumberOfTwos) * 2 + plusOne;
            int totalSpaces = iterNumberOfOnes + iterNumberOfTwos;
            ans += multinomialCoefficient(totalSpaces, iterNumberOfOnes, iterNumberOfTwos);
        }
        return ans;
    }

    private int multinomialCoefficient(int totalSpaces, int numberOfOnes, int numberOfTwos) {

        return (int) (factorial(totalSpaces) / (factorial(numberOfOnes) * factorial(numberOfTwos)));
    }

    // 0! = 1, by convention.
    private java.util.List<Long> factorialList = new java.util.ArrayList<>(java.util.Collections.singletonList(1L));

    private long factorial(int n) {
        if (factorialList.size() - 1 < n) {
            for (int i = factorialList.size() - 1; i < n; i++) {
                factorialList.add(factorialList.get(i) * (i + 1));
            }
            return factorialList.get(factorialList.size() - 1);
        } else {
            return factorialList.get(n);
        }
    }

}
