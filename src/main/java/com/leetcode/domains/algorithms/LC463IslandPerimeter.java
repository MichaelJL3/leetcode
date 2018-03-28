
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.parsers.string.IntParser;

public class LC463IslandPerimeter {

    public static void main(String[] args) {
        Solution sol = new Solution();

        Integer[][] mtx = ArgumentParser.parse2DMatrix(Integer.class, args, new IntParser());
        
        Display.print2DMatrix(mtx);

        System.out.println(sol.islandPerimeter(mtx));
    }

    static class Solution {

        private static final int maxsides = 4;

        public int islandPerimeter(Integer[][] grid) {
            int perimeter = 0;

            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    if (grid[i][j] == 1) {
                        perimeter += maxsides - 
                            ((i + 1 < grid.length ? grid[i+1][j] : 0) + 
                            (j + 1 < grid[i].length ? grid[i][j+1] : 0) + 
                            (i > 0 ? grid[i-1][j] : 0) + 
                            (j > 0 ? grid[i][j-1] : 0));
                    }
                }
            }

            return perimeter;
        }

    }

}