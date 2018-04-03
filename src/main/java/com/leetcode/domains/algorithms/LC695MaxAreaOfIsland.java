
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.parsers.string.IntParser;

public class LC695MaxAreaOfIsland {

    public static void main(String[] args) {
        Integer[][] mtx = ArgumentParser.parse2DMatrix(Integer.class, args, new IntParser());

        Display.print2DMatrix(mtx);
        System.out.println(new Solution().maxAreaOfIsland(mtx));
    }

    static class Solution {

        private boolean[][] searched;
        private Integer[][] map;

        private int sizeOfIsland(int r, int c) {            
            if (map[r][c] == 0 || searched[r][c]) return 0;
            searched[r][c] = true;
            
            return 1 + 
                (r + 1 < map.length ? sizeOfIsland(r + 1, c) : 0) + 
                (c + 1 < map[r].length ? sizeOfIsland(r, c + 1) : 0 ) + 
                (r - 1 >= 0 ? sizeOfIsland(r - 1, c) : 0 ) +
                (c - 1 >= 0 ? sizeOfIsland(r, c - 1) : 0 );
        }

        public int maxAreaOfIsland(Integer[][] grid) {
            if (grid == null || grid.length == 0) return 0;

            searched = new boolean[grid.length][grid[0].length];
            map = grid;
            int max = 0;

            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    max = Math.max(max, sizeOfIsland(i, j));
                }
            }

            return max;
        }

    }

}