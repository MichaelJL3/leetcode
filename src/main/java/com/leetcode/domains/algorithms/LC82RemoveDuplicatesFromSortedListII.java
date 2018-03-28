
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.ListNode;

public class LC82RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String arg = args.length > 0 ? args[0] : null;

		IntParser parser = new IntParser();
		ListNode<Integer> l1 = ArgumentParser.<Integer>parseList(arg, parser);
		
		Display.printList(l1);
		Display.printList(sol.deleteDuplicates(l1));
	}

	static class Solution {

		public ListNode<Integer> deleteDuplicates(ListNode<Integer> head) {
			ListNode<Integer> original = new ListNode<Integer>(0);
			ListNode<Integer> prev = original;
			boolean matched = false;
	
			if (head == null || head.next == null) return head;
			
			while (head.next != null) {
				if (head.next.val != head.val) {
					if (!matched) {
						prev.next = head;
						prev = head;
					}
					matched = false;
				} else {
					matched = true;
				}
				
				head = head.next;
			}
	
			prev.next = prev.val != head.val && !matched ? head : null;
	
			return original.next;
		}
	
	}	

}