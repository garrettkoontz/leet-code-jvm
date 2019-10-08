package com.k00ntz.leetcode;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class SolutionAddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int aLength = a.length();
        int bLength = b.length();
        int maxLength = Math.max(aLength, bLength);
        for (int i = 1; i <= maxLength; i++) {
            int aChar = (aLength - i < 0) ? 0 : a.charAt(aLength - i) - '0';
            int bChar = (bLength - i < 0) ? 0 : b.charAt(bLength - i) - '0';
            int newBit = aChar + bChar + carry;
            sb.append(newBit % 2);
            carry = newBit / 2;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
