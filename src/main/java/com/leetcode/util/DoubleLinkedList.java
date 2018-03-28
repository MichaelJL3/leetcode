
package com.leetcode.util;

public class DoubleLinkedList<T> {

    public final DoubleLinkedListNode<T> head = new DoubleLinkedListNode<T>(null);
    public final DoubleLinkedListNode<T> tail = new DoubleLinkedListNode<T>(null);

    public DoubleLinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public DoubleLinkedListNode<T> insertAtHead(T val) {
        return head.insertNode(val);
    }

    public void insertAtHead(DoubleLinkedListNode<T> node) {
        head.insertNode(node);
    }

    public DoubleLinkedListNode<T> insertAtTail(T val) {
        return tail.prev.insertNode(val);
    }

    public void insertAtTail(DoubleLinkedListNode<T> node) {
        tail.prev.insertNode(node);
    }

    public boolean empty() {
        return head.next == tail;
    }

    @Override
    public String toString() {
        DoubleLinkedListNode<T> node = head.next;
        String liststr = "";
        while (node != tail) {
            liststr += node.toString() + " -> ";
            node = node.next;
        }
        return liststr + "null";
    }

}
