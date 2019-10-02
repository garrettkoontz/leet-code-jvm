package com.k00ntz.leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SolutionSearchInsert {

    public int searchInsert(int[] nums, int target) {
        int i = nums.length / 2;
        int min = 0;
        int max = nums.length;
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        while (true) {
            int val = nums[i];
            if (val == target) {
                return i;
            } else if (target < val) {
                if (val != 0 && target > nums[i - 1]) return i;
                else {
                    max = i;
                    i = (i - min) / 2;
                }
            } else {
                if (val != nums.length && target < nums[i + 1]) return i + 1;
                else {
                    min = i;
                    i = ((max - i) / 2) + min;
                }
            }
        }
    }
}
