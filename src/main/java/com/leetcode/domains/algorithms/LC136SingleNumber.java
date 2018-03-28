
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;

import java.util.HashMap;
import java.util.Map;

public class LC136SingleNumber {

    public static void main(String[] args) {
        String arg = args.length > 0 ? args[0] : null;
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, new IntParser());

        System.out.println(new Solution().singleNumber(nums));
    }

    static class Solution {

        public int singleNumber(Integer[] nums) {
            Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

            for (int i = 0; i < nums.length; ++i) {
                if (counts.containsKey(nums[i])) {
                    counts.put(nums[i], counts.get(nums[i]) + 1);
                } else {
                    counts.put(nums[i], 1);
                }
            }

            for (Map.Entry<Integer, Integer> count : counts.entrySet()) {
                if (count.getValue() == 1) return count.getKey();
            }

            return 0;
        }

    }

}