
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Comparators;
import com.leetcode.util.parsers.string.IntParser;

public class LC485MaxConsecutiveOnes {

    public static void main(String[] args) {
        String arg = args.length > 0 ? args[0] : null;
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, new IntParser());

        System.out.println(new Solution().findMaxConsecutiveOnes(nums));
    }

    static class Solution {

        public int findMaxConsecutiveOnes(Integer[] nums) {
            int max = 0;
            int chain = 0;
            
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == 1) ++chain;
                else {
                    max = Comparators.max(max, chain);
                    chain = 0;
                }
            }

            return Comparators.max(max, chain);
        }

    }

}