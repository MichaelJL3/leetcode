
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC747LargestNumberAtLeastTwiceOfOthers {

    public static void main(String[] args) {
        String arr = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arr, new IntParser());

        System.out.println(new Solution().dominantIndex(nums));
    }

    static class Solution {

        public int dominantIndex(Integer[] nums) {
            if (nums == null || nums.length == 0) return -1;

            int max = 0;
            int indx = 0;
            int half;

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > max) {
                    max = nums[i];
                    indx = i;
                }
            }

            half = max / 2;
            nums[indx] = half;
            for (int num : nums) {
                if (num > half) return -1;
            }

            return indx;
        }

    }

}