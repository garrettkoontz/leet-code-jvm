package com.k00ntz.datastructures;

import java.util.List;

public interface Stack<T> {
    void push(T t);

    T pop();

    T peek();

    void push(List<T> t);

    List<T> pop(int i);

    List<T> peek(int i);
}
