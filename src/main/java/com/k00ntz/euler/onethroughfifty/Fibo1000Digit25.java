package com.k00ntz.euler.onethroughfifty;

import java.math.BigInteger;
import java.util.Iterator;

public class Fibo1000Digit25 {


    static class FiboIterator implements Iterator<BigInteger> {

        BigInteger secondLast = BigInteger.ONE;
        BigInteger last = BigInteger.ONE;
        int idx = 2;

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public BigInteger next() {
            idx++;
            BigInteger newLast = secondLast.add(last);
            secondLast = last;
            last = newLast;
            return last;
        }
    }

    public static int getIndexFiboMoreThan1000Digits(int minDigits) {
        BigInteger bigIntegerMinDigits = BigInteger.TEN.pow(minDigits - 1);
        for (FiboIterator it = new FiboIterator(); it.hasNext(); ) {
            BigInteger bi = it.next();
            if (bi.compareTo(bigIntegerMinDigits) > 0) {
                return it.idx;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getIndexFiboMoreThan1000Digits(3));
        System.out.println(getIndexFiboMoreThan1000Digits(1000));
    }
}
