
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.parsers.string.IntParser;

public class LC766ToeplitzMatrix {

    public static void main(String[] args) {
        Integer[][] mtx = ArgumentParser.parse2DMatrix(Integer.class, args, new IntParser());

        Display.print2DMatrix(mtx);
        System.out.println(new Solution().isToeplitzMatrix(mtx));
    }

    static class Solution {

        public boolean isToeplitzMatrix(Integer[][] matrix) {
            int diag1, diag2;
            int longestLength = Math.max(matrix.length,  matrix[0].length);

            for (int i = 0; i < longestLength; ++i) {
                diag1 = i < matrix[0].length ? matrix[0][i] : 0;
                diag2 = i < matrix.length ? matrix[i][0] : 0;
                for (int j = i + 1; j < longestLength; ++j) {
                    if (j - i < matrix.length && j < matrix[j - i].length && matrix[j - i][j] != diag1) return false;
                    else if(j < matrix.length && j - i < matrix[j].length && matrix[j][j - i] != diag2) return false;
                }
            }

            return true;
        }

    }

}