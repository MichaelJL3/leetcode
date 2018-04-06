
package com.leetcode.domains.algorithms;

import java.util.Arrays;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC561ArrayPartitionI {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, new IntParser());

        System.out.println(new Solution().arrayPairSum(nums));
    }

    static class Solution {

        public int arrayPairSum(Integer[] nums) {
            int sum = 0;

            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i+=2) {
                sum += nums[i];
            }

            return sum;
        }

    }

}