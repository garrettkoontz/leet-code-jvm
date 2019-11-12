package com.k00ntz.euler.util;

import java.util.List;

public class ListUtil {

    public static <T> T last(List<T> list) {
        if (list == null || list.isEmpty()) return null;
        else return list.get(list.size() - 1);
    }
}
