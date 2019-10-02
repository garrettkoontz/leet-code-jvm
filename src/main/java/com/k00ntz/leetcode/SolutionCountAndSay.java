package com.k00ntz.leetcode;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class SolutionCountAndSay {

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 1; i < n; i++) {
            str = nextCountAndSay(str);
        }
        return str;
    }

    private String nextCountAndSay(String str) {
        char c = str.charAt(0);
        int count = 1;
        StringBuilder retString = new StringBuilder();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                retString.append(count).append(c);
                c = str.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        return retString.append(count).append(c).toString();
    }

}
