package com.k00ntz.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionMergeSortedArrayTest {


    /*
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * Output: [1,2,2,3,5,6]
     */
    @Test
    void merge() {
        SolutionMergeSortedArray solution = new SolutionMergeSortedArray();
        int[] nums3 = new int[]{2, 0};
        solution.merge(nums3, 1, new int[]{1}, 1);
        assertArrayEquals(new int[]{1, 2}, nums3);
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        solution.merge(
                nums1, 3,
                new int[]{2, 5, 6}, 3
        );
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1
        );
    }
}