
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Comparators;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC674LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, new IntParser());

        System.out.println(new Solution().findLengthOfLCIS(nums));
    }

    static class Solution {

        public int findLengthOfLCIS(Integer[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int maxSeq = 0;
            int seq = 0;
            int prev = nums[0];

            for (int num : nums) {
                if (num <= prev) {
                    maxSeq = Comparators.max(maxSeq, seq);
                    seq = 0;
                }

                ++seq;
                prev = num;
            }

            return Comparators.max(maxSeq, seq);
        }

    }

}