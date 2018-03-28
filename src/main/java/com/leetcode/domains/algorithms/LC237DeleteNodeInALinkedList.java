
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.ListNode;
import com.leetcode.util.parsers.string.IntParser;

public class LC237DeleteNodeInALinkedList {
    
    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode<Integer> l1 = ArgumentParser.<Integer>parseList(args[0], new IntParser());
        ListNode<Integer> copy = l1;
        int node = Integer.parseInt(args[1]);

        Display.printList(l1);

        while (copy != null) {
            if 
            (copy.val == node) break;
            copy = copy.next;
        }

        sol.deleteNode(copy);

        Display.printList(l1);
    }

    static class Solution {

        public void deleteNode(ListNode<Integer> node) {
            if (node.next != null) {
                node.val = node.next.val;
                node.next = node.next.next;
            }
        }

    }

}