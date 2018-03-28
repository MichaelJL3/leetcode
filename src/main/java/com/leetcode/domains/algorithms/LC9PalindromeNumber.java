
package com.leetcode.domains.algorithms;

public class LC9PalindromeNumber {

	public static void main(String[] args) {
		int x = 0;

		if (args.length > 0) {
			x = Integer.parseInt(args[0]);
		}

		Solution sol = new Solution();
		System.out.println(sol.isPalindrome(x));
	}

	static class Solution {

		public boolean isPalindrome(int x) {
			if (x < 0) return false;
	
			int input = x;
			int reversed = 0;
	
			while (input != 0) {
				reversed *= 10;
				reversed += input % 10;
				input /= 10;
			}
	
			return reversed == x;
		}
	
	}
	
}
