
package com.leetcode.io;

import com.leetcode.util.ListNode;
import com.leetcode.util.Tuple;

import java.util.ArrayList;

public class Display {

    public static <T> void printList(ListNode<T> l1) {
        while (l1 != null) {
            System.out.print(l1.val);
            System.out.print(" -> ");
            l1 = l1.next;
        }
        System.out.println("null");
    }

    public static <T> void print2DMatrix(T[][] mtx) {
        int i = 0;

        for (T[] row : mtx) {
            for (i = 0; i < row.length - 1; ++i) {
                System.out.print(row[i]);
                System.out.print(", ");
            }
            System.out.println(row[i]);
        }
    }

    public static <T> void printArray(T[] arr) {
        int i = 0;

        for (i = 0; i < arr.length - 1; ++i) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.println(arr[i]);
    }

    public static <A, B> void printTuple(Tuple<A, B> tuple) {
        System.out.println(tuple);
    }

    public static <A, B> void printTupleList(ArrayList<Tuple<A, B>> tuples) {
        for (Tuple<A, B> tuple : tuples) {
            System.out.println(tuple);
        }
    }

}