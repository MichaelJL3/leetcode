
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Comparators;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC628MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, new IntParser());

        System.out.println(new Solution().maximumProduct(nums));
    }

    static class Solution {

        private static final int MIN = -2147483648;

        public int maximumProduct(Integer[] nums) {
            if (nums == null || nums.length <= 2) return 0; 

            int gmax = MIN;
            int mmax = MIN;
            int lmax = MIN;
            int gmin = 0;
            int lmin = 0;

            for (int num : nums) {
                if (num > gmax) {
                    lmax = mmax;
                    mmax = gmax;
                    gmax = num;
                } else if (num > mmax) {
                    lmax = mmax;
                    mmax = num;
                } else if (num > lmax) {
                    lmax = num;
                }

                if (num < gmin) {
                    lmin = gmin;
                    gmin = num;
                } else if (num < lmin) {
                    lmin = num;
                }
            }

            return gmax * Comparators.max(mmax * lmax, gmin * lmin);
        }

    }

}