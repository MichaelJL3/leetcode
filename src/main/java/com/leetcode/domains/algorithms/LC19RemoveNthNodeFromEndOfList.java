
package com.leetcode.domains.algorithms;

import com.leetcode.util.ListNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.Display;
import com.leetcode.io.ArgumentParser;

public class LC19RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		Solution<Integer> sol = new Solution<Integer>();

		if (args.length < 2) {
			System.out.println("LC19RemoveNthNodeFromEndOfList 1,2,...,n index");
			System.exit(2);
		}

		IntParser parser = new IntParser();
		ListNode<Integer> l1 = ArgumentParser.<Integer>parseList(args[0], parser);
		int index = Integer.parseInt(args[1]);

		Display.printList(l1);
		Display.printList(sol.removeNthFromEnd(l1, index));
	}

	static class Solution<T> {

		public int listSize(ListNode<T> head) {
			int size = 0;
	
			while (head != null) {
				head = head.next;
				++size;
			}
	
			return size;
		}
	
		public ListNode<T> removeNthFromEnd(ListNode<T> head, int n) {
			ListNode<T> original = head;
			int size = listSize(head);
			int index = size - n;
	
			if (size == 0 || n == 0) return head;
			else if (index <= 0) return head.next;
			
			for (int i = 1; i < index; ++i) {
				head = head.next;
			}
	
			head.next = head.next.next;
	
			return original;
		}
	
	}

}
