
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;

public class LC42TrappingRainWater {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String arg = args.length > 0 ? args[0] : null;

		IntParser parser = new IntParser();
		Integer[] heights = ArgumentParser.parseArray(Integer.class, arg, parser);
		System.out.println(sol.trap(heights));
	}

	static class Solution {

		public int trap(Integer[] heights) {
			int size = heights.length;
			int[] trappedLeft = new int[size];
			int[] trappedRight = new int[size];
	
			int heightLeft;
			int heightRight;
			int maxHeightLeft = 0;
			int maxHeightRight = 0;
			int sum = 0;
	
			for (int i = 0, j = size - 1; i < size; ++i, --j) {
				heightLeft = heights[i];
				heightRight = heights[j];
	
				maxHeightLeft = max(heightLeft, maxHeightLeft);
				maxHeightRight = max(heightRight, maxHeightRight);
	
				trappedRight[j] = maxHeightRight - heightRight;
				trappedLeft[i] = maxHeightLeft - heightLeft;
			}
	
			for (int i = 0; i < size; ++i) {
				sum += min(trappedRight[i], trappedLeft[i]);
			}
	
			return sum;
		}
	
		private int min(int a, int b) {
			return a < b ? a : b;
		}
	
		private int max(int a, int b) {
			return a > b ? a : b;
		}
	
	}

}
