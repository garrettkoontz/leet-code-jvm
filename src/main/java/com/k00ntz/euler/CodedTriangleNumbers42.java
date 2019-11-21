package com.k00ntz.euler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class CodedTriangleNumbers42 {

    private static List<String> words = null;

    static {
        try {
            words = Arrays.asList(
                    new BufferedReader(new InputStreamReader(
                            NamesScores22.class.getClassLoader().getResourceAsStream("p042_words.txt")))
                            .readLine()
                            .replace("\"", "").split(","));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
