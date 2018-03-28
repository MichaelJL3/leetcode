
package com.leetcode.domains.algorithms;

import com.leetcode.util.ListNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.Display;
import com.leetcode.io.ArgumentParser;

public class LC2AddTwoNumbers {

	public static void main(String[] args) {
		Solution sol = new Solution();

		if (args.length < 2) {
			System.out.println("LC2AddTwoNumbers 1,...,n 1,...,n");
			System.exit(2);
		}

		IntParser parser = new IntParser();
		ListNode<Integer> l1 = ArgumentParser.<Integer>parseList(args[0], parser);
		ListNode<Integer> l2 = ArgumentParser.<Integer>parseList(args[1], parser);
		ListNode<Integer> res = sol.addTwoNumbers(l1, l2);

		Display.printList(l1);
		Display.printList(l2);
		Display.printList(res);
	}

	static class Solution {

		public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
			ListNode<Integer> summed = new ListNode<Integer>(0);
			ListNode<Integer> beginning = summed;
			int sum = 0;
			int carry = 0;
	
			while (l1 != null && l2 != null) {
				sum = l1.val + l2.val + carry;
				carry = sum > 9 ? 1 : 0;
	
				summed.next = new ListNode<Integer>(sum % 10);
				summed = summed.next;
	
				l1 = l1.next;
				l2 = l2.next;
			}
	
			while (carry != 0) {
				sum = carry;
	
				if (l1 != null) {
					sum += l1.val;
					l1 = l1.next;
				} else if (l2 != null) {
					sum += l2.val;
					l2 = l2.next;
				}
	
				carry = sum > 9 ? 1 : 0;
	
				summed.next = new ListNode<Integer>(sum % 10);
				summed = summed.next;
			}
	
			summed.next = l1 != null ? l1 : l2;
	
			return beginning.next;
		}
	
	}

}