package com.k00ntz.euler.onethroughfifty;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RunAllEuler {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        List<String> classes = Arrays.asList("com.k00ntz.euler.onethroughfifty.Multiples3And51",
                "com.k00ntz.euler.onethroughfifty.EvenFibs2",
                "com.k00ntz.euler.onethroughfifty.LargestPrimeFactor3",
                "com.k00ntz.euler.onethroughfifty.LargestPalindromeProduct4",
                "com.k00ntz.euler.onethroughfifty.SmallestMultiple5",
                "com.k00ntz.euler.onethroughfifty.SumSquareDifference6",
                "com.k00ntz.euler.onethroughfifty.Prime100017",
                "com.k00ntz.euler.onethroughfifty.LargestProductInSeries8",
                "com.k00ntz.euler.onethroughfifty.SpecialPythagoreanTriplet9",
                "com.k00ntz.euler.onethroughfifty.SummationOfPrimes10",
                "com.k00ntz.euler.onethroughfifty.LargestProductInGrid11",
                "com.k00ntz.euler.onethroughfifty.HighlyDivisibleTriangleNumber12",
                "com.k00ntz.euler.onethroughfifty.LargeSum13",
                "com.k00ntz.euler.onethroughfifty.LongestCollatzSequence14",
                "com.k00ntz.euler.onethroughfifty.LatticePaths15",
                "com.k00ntz.euler.onethroughfifty.PowerDigitSum16",
                "com.k00ntz.euler.onethroughfifty.NumberLetterCounts17",
                "com.k00ntz.euler.onethroughfifty.MaximumPathSum18",
                "com.k00ntz.euler.onethroughfifty.CountingSundays19",
                "com.k00ntz.euler.onethroughfifty.FactorialDigitSum20",
                "com.k00ntz.euler.onethroughfifty.AmicableNumbers21",
                "com.k00ntz.euler.onethroughfifty.NamesScores22",
                "com.k00ntz.euler.onethroughfifty.NonAbundantSums23",
                "com.k00ntz.euler.onethroughfifty.LexicographicPermutations24",
                "com.k00ntz.euler.onethroughfifty.Fibo1000Digit25",
                "com.k00ntz.euler.onethroughfifty.ReciprocalCycles26",
                "com.k00ntz.euler.onethroughfifty.QuadraticPrimes27",
                "com.k00ntz.euler.onethroughfifty.NumberSpiralDiagonals28",
                "com.k00ntz.euler.onethroughfifty.DistinctPowers29",
                "com.k00ntz.euler.onethroughfifty.DigitFifthPowers30",
                "com.k00ntz.euler.onethroughfifty.CoinSums31",
                "com.k00ntz.euler.onethroughfifty.PandigitalProducts32",
                "com.k00ntz.euler.onethroughfifty.DigitCancellingFractions33",
                "com.k00ntz.euler.onethroughfifty.DigitFactorials34",
                "com.k00ntz.euler.onethroughfifty.CircularPrimes35",
                "com.k00ntz.euler.onethroughfifty.DoubleBasePalindromes36",
                "com.k00ntz.euler.onethroughfifty.TruncatablePrimes37",
                "com.k00ntz.euler.onethroughfifty.PandigitalMultiples38",
                "com.k00ntz.euler.onethroughfifty.IntegerRightTriangles39",
                "com.k00ntz.euler.onethroughfifty.ChampernownesConstant40",
                "com.k00ntz.euler.onethroughfifty.PandigitalPrime41",
                "com.k00ntz.euler.onethroughfifty.CodedTriangleNumbers42",
                "com.k00ntz.euler.onethroughfifty.SubStringDivisibility43",
                "com.k00ntz.euler.onethroughfifty.PentagonalNumbers44",
                "com.k00ntz.euler.onethroughfifty.TriangularPentagonalHexagonal45",
                "com.k00ntz.euler.onethroughfifty.GoldbachsOtherConjecture46",
                "com.k00ntz.euler.onethroughfifty.DistinctPrimeFactors47",
                "com.k00ntz.euler.onethroughfifty.SelfPowers48",
                "com.k00ntz.euler.onethroughfifty.PrimePermutations49",
                "com.k00ntz.euler.onethroughfifty.ConsecutivePrimeSum50"
        );
        Map<String, Long> runTimes = new LinkedHashMap<>();
        for (String s : classes) {
            Class<?> claz = Class.forName(s);
            long startTime = System.currentTimeMillis();
            claz.getMethod("main", String[].class).invoke(null, (Object) null);
            runTimes.put(s, (System.currentTimeMillis() - startTime));
        }
        runTimes.forEach((key, value) -> System.out.println("Ran " + key + " in " + value + "ms"));
        System.out.println("All runs in " + runTimes.values().stream().mapToLong(l -> l).sum() / 1000.0 + "s");
    }

}