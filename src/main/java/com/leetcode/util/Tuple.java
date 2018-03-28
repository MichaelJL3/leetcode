
package com.leetcode.util;

public class Tuple<A, B> {
    public A val1;
    public B val2;

    public Tuple(A a, B b) {
        val1 = a;
        val2 = b;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", val1.toString(), val2.toString()); 
    }
}
