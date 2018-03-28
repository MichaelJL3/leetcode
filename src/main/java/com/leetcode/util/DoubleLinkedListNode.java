
package com.leetcode.util;

public class DoubleLinkedListNode<T> {
    public T val;
    public DoubleLinkedListNode<T> next;
    public DoubleLinkedListNode<T> prev;

    public DoubleLinkedListNode(T x) {
        val = x;
    }

    public void insertNode(DoubleLinkedListNode<T> node) {
        if (next != null) {
            next.prev = node;
        }
        node.next = next;
        node.prev = this;
        next = node;
    }

    public DoubleLinkedListNode<T> insertNode(T val) {
        DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(val);
        if (next != null) {
            next.prev = node;
        }
        node.next = next;
        node.prev = this;
        next = node;
        return node;
    }

    public void removeNode() {
        if (next != null) {
            next.prev = prev;
        } 
        if (prev != null) {
            prev.next = next;
        }
        prev = null;
        next = null;
    }

    public Boolean standAlone() {
        return next == null && prev == null;
    }

    @Override
    public String toString() {
        return val != null ? val.toString() : "(null)";
    }
}