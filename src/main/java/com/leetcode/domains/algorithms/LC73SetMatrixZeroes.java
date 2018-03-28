
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

public class LC73SetMatrixZeroes {

	public static void main(String[] args) {
		Solution sol = new Solution();

		IntParser parser = new IntParser();
		Integer[][] mtx = ArgumentParser.parse2DMatrix(Integer.class, args, parser);
		
		Display.print2DMatrix(mtx);
		sol.setZeroes(mtx);
		Display.print2DMatrix(mtx);
	}

	static class Solution {

		public void setZeroes(Integer[][] matrix) {
			int rows = matrix.length;
			int cols = rows > 0 ? matrix[0].length : 0;
	
			boolean[] zerorow = new boolean[rows];
			boolean[] zerocol = new boolean[cols];
			boolean clearRow = false;
	
			for (int i = 0; i < cols; ++i) {
				zerocol[i] = false;
			}
	
			for (int i = 0; i < rows; ++i) {
				zerorow[i] = false;
	
				for (int j = 0; j < cols; ++j) {
					if (matrix[i][j] == 0) {
						zerorow[i] = true;
						zerocol[j] = true;
					}
				}
			}
	
			for (int i = 0; i < rows; ++i) {
				clearRow = zerorow[i];
	
				for (int j = 0; j < cols; ++j) {
					if (clearRow || zerocol[j]) {
						matrix[i][j] = 0;
					}
				}
			}
		}
	
	}
	
}