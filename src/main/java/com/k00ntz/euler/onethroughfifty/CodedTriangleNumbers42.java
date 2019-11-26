package com.k00ntz.euler.onethroughfifty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

    public static long triangleFor(long n) {
        return n * (n + 1) / 2;
    }

    public static Set<Long> triangleNumbers = LongStream.rangeClosed(1, 1000)
            .map(CodedTriangleNumbers42::triangleFor).boxed().collect(Collectors.toSet());

    public static boolean isTriangleWord(String s) {
        long sum = 0;
        for (char c :
                s.toCharArray()) {
            sum += c - 'A' + 1;
        }
        return triangleNumbers.contains(sum);
    }

    public static void main(String[] args) {
        System.out.println(isTriangleWord("SKY"));
        System.out.println(words.stream().filter(CodedTriangleNumbers42::isTriangleWord).count());
    }
}
