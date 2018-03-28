
package com.leetcode.domains.algorithms;

import com.leetcode.util.ListNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

public class LC21MergeTwoSortedLists {

    public static void main(String[] args) {
        Solution sol = new Solution();

        if (args.length < 2) {
            System.out.println("LC21MergeTwoSortedLists 1,2,...,n 1,2,...,n");
            System.exit(2);
        }

        IntParser parser = new IntParser();
        ListNode<Integer> l1 = ArgumentParser.<Integer>parseList(args[0], parser);
        ListNode<Integer> l2 = ArgumentParser.<Integer>parseList(args[1], parser);
        
        Display.printList(l1);
        Display.printList(l2);
        Display.printList(sol.mergeTwoLists(l1, l2));
    }

    static class Solution {

        public ListNode<Integer> mergeTwoLists(ListNode<Integer> l1, ListNode<Integer> l2) {
            ListNode<Integer> merged = new ListNode<Integer>(0);
            ListNode<Integer> original = merged;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    merged.next = new ListNode<Integer>(l1.val);
                    l1 = l1.next;
                } else {
                    merged.next = new ListNode<Integer>(l2.val);
                    l2 = l2.next;
                }

                merged = merged.next;
            }

            merged.next = l1 != null ? l1 : l2;

            return original.next;
        }

    }

}
