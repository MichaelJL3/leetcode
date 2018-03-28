
package com.leetcode.util;

public class ListNode<T> {
    public T val;
    public ListNode<T> next;

    public ListNode(T x) {
        val = x;
    }

    @Override
    public String toString() {
        String listStr = val + " -> ";
        ListNode<T> node = next;

        while (node != null) {
            listStr += node.val.toString() + " -> ";
            node = node.next;
        }
    
        return listStr + "null";
    }
}