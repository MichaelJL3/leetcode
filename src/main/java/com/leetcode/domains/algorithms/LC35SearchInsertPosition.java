
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;

public class LC35SearchInsertPosition {

    public static void main(String[] args) {
        Solution sol = new Solution();

        if (args.length < 2) {
            System.out.println("LC35SearchInsertPosition 1,2,3,...,n target");
            System.exit(2);
        }

        IntParser parser = new IntParser();
        Integer[] nums = ArgumentParser.parseArray(Integer.class, args[0], parser);
        int target = Integer.parseInt(args[1]);

        System.out.println(sol.searchInsert(nums, target));
    }

    static class Solution {

        public int searchInsert(Integer[] nums, int target) {
            int upperBound = nums.length - 1;
            int lowerBound = 0;
            int midPoint = 0;

            while (upperBound >= lowerBound && upperBound < nums.length) {
                midPoint = lowerBound + (upperBound - lowerBound) / 2;
            
                if (nums[midPoint] > target) {
                    upperBound = midPoint - 1;
                } else if (nums[midPoint] < target) {
                    lowerBound = midPoint + 1;
                } else {
                    return midPoint;
                }
            }

            return nums[midPoint] < target ? midPoint + 1 : midPoint;
        }

    }

}
