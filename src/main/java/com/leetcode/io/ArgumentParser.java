
package com.leetcode.io;

import com.leetcode.util.parsers.Parser;
import com.leetcode.util.ListNode;
import com.leetcode.util.Tuple;

import java.util.ArrayList;
import java.lang.reflect.Array;

@SuppressWarnings({"unchecked", "rawtypes"})
public class ArgumentParser {
    
    public static <T> ListNode<T> parseList(String list, Parser parser) {
        ListNode<T> l1 = new ListNode<T>(null);
        ListNode<T> ol1 = l1;

        if (list == null) return null;

        String[] listElements = list.split(",");
        for (String val : listElements) {
            l1.next = new ListNode(parser.parse(val));
            l1 = l1.next;
        }

        return ol1.next;
    }

    public static <T> ListNode<T> parseList(String[] list, Parser parser) {
        ListNode<T> l1 = new ListNode<T>(null);
        ListNode<T> ol1 = l1;

        if (list == null) return null;

        for (String val : list) {
            l1.next = new ListNode(parser.parse(val));
            l1 = l1.next;
        }

        return ol1.next;
    }

    public static <T> T[] parseArray(Class<T> type, String array, Parser parser) {
        if (array == null) return null;

        String[] arrayElements = array.split(",");
        T[] vals = (T[]) Array.newInstance(type, arrayElements.length);

        for (int i = 0; i < arrayElements.length; ++i) {
            vals[i] = (T) parser.parse(arrayElements[i]);
        }

        return vals;
    }

    public static <T> T[] parseArray(Class<T> type, String[] array, Parser parser) {
        if (array == null) return null;

        T[] vals = (T[]) Array.newInstance(type, array.length);

        for (int i = 0; i < array.length; ++i) {
            vals[i] = (T) parser.parse(array[i]);
        }

        return vals;
    }

    public static <T> T[][] parse2DMatrix(Class<T> type, String[] matrix, Parser parser) {
        if (matrix == null) return null;

        T[][] mtx = (T[][]) Array.newInstance(type, matrix.length, matrix.length);

        for (int i = 0; i < matrix.length; ++i) {
            mtx[i] = (T[]) parseArray(type, matrix[i], parser);
        }

        return mtx;
    }

    public static <A, B> Tuple<A, B> parseTuple(String tuple, Parser parser) {
        if (tuple == null) return null;

        String[] tupleArgs = tuple.split(",");
        A arg0 = null;
        B arg1 = null;

        if (tupleArgs.length > 0) {
            arg0 = (A) parser.parse(tupleArgs[0]);
        }
        if (tupleArgs.length > 1) {
            arg1 = (B) parser.parse(tupleArgs[1]);
        }

        return new Tuple<A, B>(arg0, arg1);
    }

    public static <A, B> ArrayList<Tuple<A, B>> parseTupleList(String[] tuples, Parser parser) {
        ArrayList<Tuple<A, B>> list = new ArrayList<Tuple<A, B>>();

        if (tuples == null) return null;

        for (String tuple : tuples) {
            list.add(ArgumentParser.<A, B>parseTuple(tuple, parser));
        }

        return list;
    }

    public static <T> T parseArg(String[] args, int position, Parser parser) {
        return args.length > position ? (T) parser.parse(args[position]) : null;
    }

}
