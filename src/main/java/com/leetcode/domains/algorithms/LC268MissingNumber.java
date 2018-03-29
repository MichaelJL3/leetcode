
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Comparators;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC268MissingNumber {

    public static void main(String[] args) {
        String arr = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arr, new IntParser());

        System.out.println(new Solution().missingNumber(nums));
    }

    static class Solution {

        public int missingNumber(Integer[] nums) {
            if (nums == null || nums.length == 0) return 0;

            int sumAll = 0;
            int sumNum = 0;
            int max = 0;

            for (int num : nums) {
                max = Comparators.max(max, num + 1);
                sumNum += num + 1;
            }

            sumAll = max * (max + 1) / 2;

            return sumAll - sumNum == 0 ? max : sumAll - sumNum - 1;
        }

    }

}