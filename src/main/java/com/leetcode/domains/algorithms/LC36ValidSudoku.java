
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.CharParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

import java.lang.Math;

public class LC36ValidSudoku {

	public static void main(String[] args) {
		Solution sol = new Solution();

		CharParser parser = new CharParser();
		Character[][] board = ArgumentParser.parse2DMatrix(Character.class, args, parser);

		Display.print2DMatrix(board);
		System.out.println(sol.isValidSudoku(board));
	}

	static class Solution {
    
		public boolean isValidNumber(int x) {
			return x > 0 && x < 10 ? true : false;
		}
		
		public int whichBox(int row, int col) {
			int prevRowBoxes = ( (int) Math.ceil( (row + 1) / 3.0 ) - 1 ) * 3;
			int rowBoxes = (int) Math.ceil( (col + 1) / 3.0);
			return prevRowBoxes + rowBoxes - 1;
		}
		
		public boolean isValidSudoku(Character[][] board) {
			if (board == null) return false;

			int rows = board.length;
			int cols = rows;
	
			int[][] boxCounts = new int[rows][cols + 1];
			int[][] rowCounts = new int[rows][cols + 1];
			int[][] colCounts = new int[rows][cols + 1];
			int[] possibleValues = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			int val;
			int dot = (int)'.';
			
			for (int i = 0; i < rows; ++i) {
				for (int j = 0; j < cols; ++j) {
					val = (int)board[i][j];
					
					if (val != dot) {
						val -= 48;
	
						if (isValidNumber(val) == false) return false;
	
						++boxCounts[whichBox(i, j)][val];
						++rowCounts[i][val];
						++colCounts[j][val];
					}
				}
			}
			
			for (int i = 0; i < rows; ++i) {
				for (int num : possibleValues) {
					if (num < cols + 1)
						if(boxCounts[i][num] > 1 || rowCounts[i][num] > 1 || colCounts[i][num] > 1)
							return false;
				}
			}
			
			return true;
		}
		
	}

}