
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.ListNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC141LinkedListCycle {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        ListNode<Integer> list = ArgumentParser.parseList(arg, new IntParser());
        //list.next = list;
        System.out.println(new Solution().hasCycle(list));
    }

    static class Solution {

        public boolean hasCycle(ListNode<Integer> head) {
            if (head == null || head.next == null) return false;

            ListNode<Integer> fast = head.next.next;
            
            while (head != null && fast != null && fast.next != null) {
                if (fast == head) return true;
                fast = fast.next.next;
                head = head.next;
            }

            return false;
        }

    }

}