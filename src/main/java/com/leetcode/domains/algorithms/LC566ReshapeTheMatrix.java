
package com.leetcode.domains.algorithms;

import java.util.Arrays;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.parsers.string.IntParser;

public class LC566ReshapeTheMatrix {

    public static void main(String[] args) {
        IntParser parser = new IntParser();

        Integer[][] mtx = ArgumentParser.parse2DMatrix(Integer.class, Arrays.copyOf(args, args.length - 2), parser);
        int r = ArgumentParser.parseArg(args, args.length - 2, parser);
        int c = ArgumentParser.parseArg(args, args.length - 1, parser);

        Display.print2DMatrix(mtx);
        Display.print2DMatrix(new Solution().matrixReshape(mtx, r, c));
    }

    static class Solution {

        public Integer[][] matrixReshape(Integer[][] nums, int r, int c) {
            if (nums.length == 0) return nums;
            
            int orows = nums.length;
            int ocols = nums[0].length;
            
            if (r * c != orows * ocols) return nums;
            
            Integer[][] newMtx = new Integer[r][c];
            int orow, ocol;
            int pos = 0;
            
            for (int i = 0; i < r; ++i) {
                for (int j = 0; j < c; ++j) {
                    orow = (pos + j) / ocols;
                    ocol = (pos + j) - orow * ocols;
                    newMtx[i][j] = nums[orow][ocol];
                }
                pos += c;
            }
            
            return newMtx;
        }

    }

}