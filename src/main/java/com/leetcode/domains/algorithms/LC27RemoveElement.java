
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

public class LC27RemoveElement {

	public static void main(String[] args) {
		Solution sol = new Solution();
		
		if (args.length < 2) {
			System.out.println("LC27RemoveElement 1,2,...,n 3");
			System.exit(2);
		}

		IntParser parser = new IntParser();
		Integer[] nums = ArgumentParser.parseArray(Integer.class, args[0], parser);
		int val = Integer.parseInt(args[1]);

		System.out.println(sol.removeElement(nums, val));
		Display.printArray(nums);
	}

	static class Solution {

		public int removeElement(Integer[] nums, int val) {
			int size = nums.length;
			int offset = 0;
	
			for (int i = 0; i < size; ++i, ++offset) {
				nums[offset] = nums[i];
				if (nums[i] == val) --offset;
			}
	
			return offset;
		}
	
	}

}
