package com.k00ntz.leetcode;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */

public class SolutionLongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        int i = 0;
        boolean stop = false;
        StringBuilder prefix = new StringBuilder();
        while (!stop){
            Character nextChar = null;
            for (String s : strs){
                if(i == s.length()){
                    stop = true;
                } else {
                    if (nextChar == null){
                        nextChar = s.charAt(i);
                    } else {
                        if(!nextChar.equals(s.charAt(i))){
                            stop = true;
                        }
                    }
                }
            }
            if(!stop) {
                prefix.append(nextChar);
            }
            i++;
        }
        return prefix.toString();
    }

}
