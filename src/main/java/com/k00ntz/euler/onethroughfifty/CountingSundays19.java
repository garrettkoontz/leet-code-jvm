package com.k00ntz.euler.onethroughfifty;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 * <p>
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */
public class CountingSundays19 {

    public static int[] monthLengths = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    public static int[] leapYearMonthLengths = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    public static int weekLength = 7;

    public static int countMonthStartSundaysInAYear(int jan1DayOfWeek, boolean isLeapYear) {
        int count = jan1DayOfWeek == 0 ? 1 : 0;
        int startDay = jan1DayOfWeek;
        for (int i : isLeapYear ? leapYearMonthLengths : monthLengths) {
            startDay = (startDay + i) % weekLength;
            count += startDay == 0 ? 1 : 0;
        }
        return count;
    }

    public static boolean isLeapYear(int y) {
        return y % 4 == 0 && (y % 100 != 0 || y % 400 == 0);
    }

    public static Map<Integer, Integer> countMap;

    static {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x = 0; x < 14; x++) {
            if (map.put(x, countMonthStartSundaysInAYear(x, (x / weekLength) == 1)) != null) {
                throw new IllegalStateException("Duplicate key");
            }
        }
        countMap = map;
    }

    public static int countMonthStartSundaysInARange(int jan1DayOfWeek, int numberOfYears, int startYear) {
        int count = 0;
        int startDayOfWeek = jan1DayOfWeek;
        for (int i = 0; i < numberOfYears; i++) {
            boolean isLeapYear = isLeapYear(startYear + i);
            count += countMap.get(startDayOfWeek + (isLeapYear ? weekLength : 0));
            startDayOfWeek = (startDayOfWeek + (isLeapYear ? 366 : 365)) % weekLength;
        }
        return count;
    }

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(1901, 1, 1);
        LocalDate date = startDate;
        int count = 0;
        LocalDate endDate = LocalDate.of(2000, 12, 31);
        while (date.isBefore(endDate)) {
            if (date.getDayOfMonth() == 1 && date.getDayOfWeek() == DayOfWeek.SUNDAY) count++;
            date = date.plusMonths(1);
        }
        System.out.println(count);

        System.out.println(countMonthStartSundaysInARange(366 % weekLength, 100, 1901));
    }

}
