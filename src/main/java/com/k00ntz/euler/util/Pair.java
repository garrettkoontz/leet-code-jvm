package com.k00ntz.euler.util;

public class Pair<A, B> {
    public A _1;
    public B _2;

    public Pair(A a, B b) {
        this._1 = a;
        this._2 = b;
    }

    @Override
    public String toString() {
        return "(" + _1 + ", " + _2 + ")";
    }
}
