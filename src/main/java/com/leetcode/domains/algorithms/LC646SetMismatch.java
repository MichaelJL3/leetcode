
package com.leetcode.domains.algorithms;

import java.util.Map;
import java.util.HashMap;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.Comparators;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC646SetMismatch {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] nums = ArgumentParser.parseArray(Integer.class, arg, new IntParser());

        Display.printArray(new Solution().findErrorNums(nums));
    }

    static class Solution {

        public Integer[] findErrorNums(Integer[] nums) {
            Map<Integer, Boolean> counts = new HashMap<Integer,Boolean>();
            int sum = 0;
            int max = 0;
            int duplicate = 0;
            int missing = 0;

            for (int num : nums) {
                max = Comparators.max(max, num);
                sum += num;
                
                if (counts.containsKey(num)) {
                    duplicate = num;
                }

                counts.put(num, true);
            }

            if (max != duplicate || counts.get(duplicate - 1) == null && duplicate - 1 > 0) {
                missing = (max * (max + 1) / 2) - (sum - duplicate);
            }

            missing = missing == 0 ? max + 1 : missing;
            duplicate = duplicate == 0 ? missing : duplicate;

            return missing != 0 && duplicate != 0 ? new Integer[] {duplicate, missing} : new Integer[] {};
        }

    }

}