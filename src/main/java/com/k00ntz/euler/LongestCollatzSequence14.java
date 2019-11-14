package com.k00ntz.euler;

import java.util.Iterator;

public class LongestCollatzSequence14 {

    private static class CollatzIter implements Iterator<Integer> {

        private int internalNum;

        public CollatzIter(int startNum) {
            startNum = internalNum;
        }

        @Override
        public boolean hasNext() {
            return internalNum > 1;
        }

        @Override
        public Integer next() {
            internalNum = internalNum % 2 == 0 ? internalNum / 2 : 3 * internalNum + 1;
            return internalNum;
        }
    }

    public static int countCollatz(int i) {
        int j = 0;
        CollatzIter iter = new CollatzIter(i);
        for (; iter.hasNext(); ) {
            iter.next();
            j++;
        }
        return j;
    }


    public static class CollatzCounter implements Runnable {
        public CollatzCounter(int i) {

        }
    }

    public static int longestCollatz(int maxStart) {

    }

    public static void main(String[] args) {

    }

}
