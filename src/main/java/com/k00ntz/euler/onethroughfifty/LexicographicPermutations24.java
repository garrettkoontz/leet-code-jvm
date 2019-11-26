package com.k00ntz.euler.onethroughfifty;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LexicographicPermutations24 {

    private static class LexicographicIterator implements Iterator<Long> {

        private int[] currentPermutation;

        public LexicographicIterator(int[] values) {
            currentPermutation = Arrays.copyOf(values, values.length);
            Arrays.sort(currentPermutation);
        }

        @Override
        public boolean hasNext() {
            return getNextIndex() >= 0;
        }

        private int getNextIndex() {
            int k = -1;
            for (int i = 0; i < currentPermutation.length - 1; i++) {
                if (currentPermutation[i] < currentPermutation[i + 1]) k = i;
            }
            return k;
        }

        /**
         * The following algorithm generates the next permutation lexicographically after a given permutation. It changes
         * the given permutation in-place.
         * <p>
         * Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
         * Find the largest index l greater than k such that a[k] < a[l].
         * Swap the value of a[k] with that of a[l].
         * Reverse the sequence from a[k + 1] up to and including the final element a[n].
         *
         * @return the next integer in the series;
         */
        @Override
        public Long next() {
            int k = getNextIndex();
            if (k < 0) throw new NoSuchElementException();
            int l = k;
            for (int i = k + 1; i < currentPermutation.length; i++) {
                if (currentPermutation[k] < currentPermutation[i]) l = i;
            }
            swap(currentPermutation, k, l);
            reverse(currentPermutation, k + 1, currentPermutation.length - 1);

            return intArrayToLong(currentPermutation);
        }

        private static Long intArrayToLong(int[] array) {
            StringBuilder sb = new StringBuilder();
            for (int i :
                    array) {
                sb.append(i);
            }
            return java.lang.Long.parseLong(sb.toString());
        }

        private static void swap(int[] array, int i, int j) {
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }

        private static void reverse(int[] array, int i, int j) {
            while (i < j) {
                swap(array, i++, j--);
            }
        }
    }

    public static void main(String[] args) {
        Iterator<Long> sourceIterator = new LexicographicIterator(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        for (int i = 0; i < 999998; i++) {
            sourceIterator.next();
        }
        System.out.println(sourceIterator.next());
    }

}
