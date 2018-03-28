
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.parsers.string.IntParser;

import java.util.HashMap;
import java.util.Map;

public class LC167TwoSumII {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("LC167TwoSumII 1,2,...n t");
            System.exit(2);
        }

        Integer[] nums = ArgumentParser.parseArray(Integer.class, args[0], new IntParser());
        int tgt = Integer.parseInt(args[1]);

        Display.printArray(new Solution().twoSum(nums, tgt));
    }

    static class Solution {

        public Integer[] twoSum(Integer[] numbers, int target) {
            Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();

            for (int i = 0; i < numbers.length; ++i) {
                numMap.put(numbers[i], i);
            }

            for (int i = 0; i < numbers.length; ++i) {
                if (numMap.containsKey(target - numbers[i])) {
                    return new Integer[] {i + 1, numMap.get(target - numbers[i]) + 1};
                }
            }

            return null;
        }

    }

}