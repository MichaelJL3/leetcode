
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.ListNode;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

public class LC24SwapNodesInPairs {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String arg = args.length > 0 ? args[0] : null;

        IntParser parser = new IntParser();
        ListNode<Integer> l1 = ArgumentParser.<Integer>parseList(arg, parser);

        Display.printList(l1);
        Display.printList(sol.swapPairs(l1));
    }

    static class Solution {

        public ListNode<Integer> swapPairs(ListNode<Integer> head) {
            ListNode<Integer> swapped = new ListNode<Integer>(0);
            ListNode<Integer> orig = swapped;
            ListNode<Integer> prev = null;

            while (head != null) {
                if (prev != null) {
                    swapped.next = head;
                    swapped = swapped.next;
                    head = head.next;

                    swapped.next = prev;
                    swapped = swapped.next;
                    prev = null;
                } else {
                    prev = head;
                    head = head.next;
                }
            }

            swapped.next = prev;
            return orig.next;
        }

    }

}
