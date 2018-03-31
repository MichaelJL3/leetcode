
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC643MaximumAverageSubarrayI {

    public static void main(String[] args) {
        IntParser intParser = new IntParser();

        String arg1 = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arg1, intParser);

        int k = ArgumentParser.parseArg(args, 1, intParser);

        System.out.println(new Solution().findMaxAverage(nums, k));
    }

    static class Solution {

        public double findMaxAverage(Integer[] nums, int k) {
            long totalSub = 0;
            long max;

            for (int i = 0; i < k; ++i) {
                totalSub += nums[i];
            }

            max = totalSub;
            for (int i = k; i < nums.length; ++i) {
                totalSub += (nums[i] - nums[i - k]);
                max = Math.max(max, totalSub);
            }

            return max / (double) k;
        }

    }

}