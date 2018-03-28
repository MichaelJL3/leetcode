
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

public class LC80RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String arg = args.length > 0 ? args[0] : null;

		IntParser parser = new IntParser();
		Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, parser);

		Display.printArray(nums);
		System.out.println(sol.removeDuplicates(nums));
		Display.printArray(nums);
	}

	static class Solution {

		public int removeDuplicates(Integer[] nums) {
			int offset = 0;
			int size = nums.length;
			boolean encountered = false;

			if (size == 0) return 0;

			for (int i = 0; i < size - 1; ++i, ++offset) {
				nums[offset] = nums[i];
				if (nums[offset] == nums[i + 1]) {
					if (encountered) {
						--offset;
					} else {
						encountered = true;
					}
				} else {
					encountered = false;
				}
			}

			nums[offset++] = nums[size - 1];

			return offset;
		}

	}

}