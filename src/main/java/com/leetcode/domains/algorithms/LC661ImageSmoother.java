
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.parsers.string.IntParser;

public class LC661ImageSmoother {

    public static void main(String[] args) {
        Integer[][] img = ArgumentParser.parse2DMatrix(Integer.class, args, new IntParser());
        Display.print2DMatrix(img);
        Display.print2DMatrix(new Solution().imageSmoother(img));
    }

    static class Solution {

        public Integer[][] imageSmoother(Integer[][] M) {
            Integer [][] img = new Integer[M.length][];
            int rows = M != null ? M.length - 1 : 0;
            int cols = M != null ? M[0].length - 1 : 0;
            int sum;
            int count;

            for (int i = 0; i < M.length; ++i) {
                img[i] = new Integer[M[i].length];

                for (int j = 0; j < M[i].length; ++j) {
                    sum = 0;
                    count = 1;

                    if (i != 0) {
                        if (j != 0) {
                            sum += M[i - 1][j - 1];
                            ++count;
                        } if (j != cols) {
                            sum += M[i - 1][j + 1];
                            ++count;
                        }
                        sum += M[i - 1][j];
                        ++count;
                    } if (i != rows) {
                        if (j != 0) {
                            sum += M[i + 1][j - 1];
                            ++count;
                        } if (j != cols) {
                            sum += M[i + 1][j + 1];
                            ++count;
                        }
                        sum += M[i + 1][j];
                        ++count;
                    } if (j != 0) {
                        sum += M[i][j - 1];
                        ++count;
                    } if (j != cols) {
                        sum += M[i][j + 1];
                        ++count;
                    }
                    
                    img[i][j] = (sum + M[i][j]) / count;
                }
            }

            return img;
        }

    }

}