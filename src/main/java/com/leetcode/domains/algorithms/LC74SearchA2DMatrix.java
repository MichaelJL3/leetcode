
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

import java.util.Arrays;

public class LC74SearchA2DMatrix {

    public static void main(String[] args) {
        Solution sol = new Solution();
 
        if (args.length < 2) {
            System.out.println("LC74SearchA2DMatrix 1,2,...,n 1,2,...,n target");
            System.exit(2);
        }

        IntParser parser = new IntParser();
        Integer[][] matrix = ArgumentParser.parse2DMatrix(
            Integer.class, Arrays.copyOf(args, args.length - 1), parser
        );

        int target = Integer.parseInt(args[args.length - 1]);

        Display.print2DMatrix(matrix);
        System.out.println(sol.searchMatrix(matrix, target));
    }

    static class Solution {

        private int findTargetRow(Integer[][]matrix, int target) {
            Integer[] row;
    
            for (int i = 0; i < matrix.length; ++i) {
                row = matrix[i];
                if (row.length > 0 && target <= row[row.length-1])
                    return i;
            }
    
            return -1;
        }
    
        private boolean isInRow(Integer[] row, int target) {
            int lowerBound = 0;
            int upperBound = row.length;
            int midPoint = 0;
    
            while (upperBound >= lowerBound) {
                midPoint = lowerBound + ( upperBound - lowerBound ) / 2;
    
                if (row[midPoint] < target) {
                    lowerBound = midPoint + 1;
                } else if (row[midPoint] > target) {
                    upperBound = midPoint - 1;
                } else {
                    return true;
                }
            }
    
            return false;
        } 
    
        public boolean searchMatrix(Integer[][] matrix, int target) {
            int row = findTargetRow(matrix, target);
            return (row == -1) ? false : isInRow(matrix[row], target);
        }
    
    }

}
