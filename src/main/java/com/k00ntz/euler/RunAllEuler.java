package com.k00ntz.euler;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RunAllEuler {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<String> classes = Arrays.asList("com.k00ntz.euler.Multiples3And51",
                "com.k00ntz.euler.EvenFibs2",
                "com.k00ntz.euler.LargestPrimeFactor3",
                "com.k00ntz.euler.LargestPalindromeProduct4",
                "com.k00ntz.euler.SmallestMultiple5",
                "com.k00ntz.euler.SumSquareDifference6",
                "com.k00ntz.euler.Prime100017",
                "com.k00ntz.euler.LargestProductInSeries8",
                "com.k00ntz.euler.SpecialPythagoreanTriplet9",
                "com.k00ntz.euler.SummationOfPrimes10",
                "com.k00ntz.euler.LargestProductInGrid11",
                "com.k00ntz.euler.HighlyDivisibleTriangleNumber12",
                "com.k00ntz.euler.LargeSum13",
                "com.k00ntz.euler.LongestCollatzSequence14",
                "com.k00ntz.euler.LatticePaths15",
                "com.k00ntz.euler.PowerDigitSum16",
                "com.k00ntz.euler.NumberLetterCounts17",
                "com.k00ntz.euler.MaximumPathSum18",
                "com.k00ntz.euler.CountingSundays19",
                "com.k00ntz.euler.FactorialDigitSum20",
                "com.k00ntz.euler.AmicableNumbers21",
                "com.k00ntz.euler.NamesScores22",
                "com.k00ntz.euler.NonAbundantSums23",
                "com.k00ntz.euler.LexicographicPermutations24",
                "com.k00ntz.euler.Fibo1000Digit25",
                "com.k00ntz.euler.ReciprocalCycles26",
                "com.k00ntz.euler.QuadraticPrimes27",
                "com.k00ntz.euler.NumberSpiralDiagonals28",
                "com.k00ntz.euler.DistinctPowers29",
                "com.k00ntz.euler.DigitFifthPowers30",
                "com.k00ntz.euler.CoinSums31",
                "com.k00ntz.euler.PandigitalProducts32",
                "com.k00ntz.euler.DigitCancellingFractions33",
                "com.k00ntz.euler.DigitFactorials34",
                "com.k00ntz.euler.CircularPrimes35",
                "com.k00ntz.euler.DoubleBasePalindromes36",
                "com.k00ntz.euler.TruncatablePrimes37",
                "com.k00ntz.euler.PandigitalMultiples38"
        );
        List<String> runTimes = new ArrayList<>();
        for (String s : classes) {
            Class<?> claz = Class.forName(s);
            long startTime = System.currentTimeMillis();
            claz.getMethod("main", String[].class).invoke(null, (Object) null);
            runTimes.add("Ran " + s + " in " + (System.currentTimeMillis() - startTime) + "ms");
        }
        runTimes.forEach(System.out::println);
    }

}
