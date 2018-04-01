
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.ListNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC203RemoveLinkedListElements {

    public static void main(String[] args) {
        IntParser parser = new IntParser();

        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        int val = ArgumentParser.parseArg(args, 1, parser);
        ListNode<Integer> list = ArgumentParser.parseList(arg, parser);

        Display.printList(list);
        Display.printList(new Solution().removeElements(list, val));
    }

    static class Solution {

        public ListNode<Integer> removeElements(ListNode<Integer> head, int val) {
            ListNode<Integer> orig = new ListNode<Integer>(0);
            ListNode<Integer> copy = orig;

            while (head != null) {
                if (head.val != val) {
                    copy.next = head;
                    copy = copy.next;
                }
                head = head.next;
            }

            copy.next = null;
            return orig.next;
        }

    }

}