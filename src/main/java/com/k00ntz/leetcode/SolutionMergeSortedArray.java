package com.k00ntz.leetcode;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 * from nums2.
 * Example:
 * <p>
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 */

public class SolutionMergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) nums1 = nums2;
        if (nums2.length == 0) return;
        int i = 0;
        int j = 0;
        while (i < nums1.length || j < n) {
            if ((j < nums2.length && nums1[i] > nums2[j]) || i >= m) {
                if (nums1.length - 1 - i >= 0)
                    System.arraycopy(nums1, i, nums1, i + 1, nums1.length - 1 - i);
                nums1[i++] = nums2[j++];
                m++;
            } else {
                i++;
            }
        }
    }
}
