package com.k00ntz.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value
 * by its alphabetical position in the list to obtain a name score.
 * <p>
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the
 * 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 * <p>
 * What is the total of all the name scores in the file?
 */
public class NamesScores22 {

    private static List<String> names = null;

    static {
        try {
            names = Arrays.asList(
                    new BufferedReader(new InputStreamReader(
                            NamesScores22.class.getClassLoader().getResourceAsStream("p022_names.txt")))
                            .readLine()
                            .replace("\"", "").split(","));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int scoreName(String s) {
        int score = 0;
        for (char c : s.toCharArray()) {
            score += c - 'A' + 1;
        }
        return score;
    }

    public static long scoreNames(List<String> names) {
        List<String> internalNames = new ArrayList<>(names);
        Collections.sort(internalNames);
        long score = 0;
        for (int i = 0; i < internalNames.size(); i++) {
            score += ((i + 1) * (long) scoreName(internalNames.get(i)));
        }
        return score;
    }

    public static void main(String[] args) {

        System.out.println(scoreNames(names));
        //871190344
        //871198282
    }

}
