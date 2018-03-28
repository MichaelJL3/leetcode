
package com.leetcode.util;

import java.lang.Comparable;

public class Comparators {

    public static <T extends Comparable<T>> int compare(T a, T b) {
        return a.compareTo(b);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return compare(a, b) < 0 ? b : a;
    }

    public static <T extends Comparable<T>> T min(T a, T b) {
        return compare(a, b) < 0 ? a : b;
    }

}