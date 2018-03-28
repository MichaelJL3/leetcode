
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

public class LC66PlusOne {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String arg = args.length > 0 ? args[0] : null;

		IntParser parser = new IntParser();
		Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, parser);

		Display.printArray(sol.plusOne(nums));
	}

	static class Solution {

		private Integer[] addOneLeft(Integer[] digits) {
			Integer[] shifted = new Integer[digits.length + 1];
	
			shifted[0] = 1;
			for (int i = 0; i < digits.length; ++i) {
				shifted[i + 1] = digits[i];
			}
	
			return shifted;
		}
	
		public Integer[] plusOne(Integer[] digits) {
			int digit;
			boolean carry = true;
	
			for (int i = digits.length - 1; i >= 0; --i) {
				digit = carry == true ? digits[i] + 1 : digits[i];
				if (digit > 9) {
					digit %= 10;
				} else {
					carry = false;
				}
	
				digits[i] = digit;
			}
	
			return carry ? addOneLeft(digits) : digits;
		}
	
	}
	
}
