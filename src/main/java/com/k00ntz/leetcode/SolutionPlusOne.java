package com.k00ntz.leetcode;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the
 * array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class SolutionPlusOne {

    public int[] plusOne(int[] digits) {
        boolean propagate = digits[digits.length - 1] == 9;
        if (!propagate) {
            digits[digits.length - 1]++;
            return digits;
        } else {
            digits[digits.length - 1] = 0;
            int i = digits.length - 2;
            while (true) {
                if (i == -1) {
                    int[] newDigits = new int[digits.length + 1];
                    System.arraycopy(digits, 0, newDigits, 1,
                            digits.length);
                    newDigits[0] = 1;
                    return newDigits;
                }
                if (digits[i] == 9) {
                    digits[i] = 0;
                    i--;
                } else {
                    digits[i]++;
                    break;
                }
            }
        }
        return digits;
    }
}
