
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC724FindPivotIndex {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, new IntParser());

        System.out.println(new Solution().pivotIndex(nums));
    }

    static class Solution {

        public int pivotIndex(Integer[] nums) {
            long rightSum = 0;
            long leftSum = 0;
            
            for (int i = nums.length - 1; i >= 0; --i) {
                rightSum += nums[i];
            }

            for (int i = 0; i < nums.length; ++i) {
                if ((rightSum - leftSum) - nums[i] == leftSum) return i;
                leftSum += nums[i];
            }

            return -1;
        }

    }

}