/*
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Comparators;
import com.leetcode.util.parsers.string.IntParser;

import java.util.Map;
import java.util.HashMap;

public class LC220ContainsDuplicatesIII {

    public static void main(String[] args) {
        Solution sol = new Solution();

        if (args.length < 3) {
            System.out.println("");
            System.exit(2);
        }

        IntParser parser = new IntParser();
        Integer[] nums = ArgumentParser.parseArray(Integer.class, args[0], parser);
        int k = Integer.parseInt(args[1]);
        int t = Integer.parseInt(args[2]);

        System.out.println(sol.containsNearbyAlmostDuplicate(nums, k, t));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    static class Solution {

        public boolean containsNearbyAlmostDuplicate(Integer[] nums, int k, int t) {
            Map<Integer, Integer> smallMap = new HashMap();

            for (int i = 0, index = 0; i < nums.length; ++i, index = i/k) {

                if (smallMap.containsKey(index)) {
                    smallMap.put(index, Comparators.min(Math.abs(nums[i])-t, smallMap.get(index)));
                } else {
                    smallMap.put(index, Math.abs(nums[i])-t);
                }
            }

            for (int i = 0, index = 0; i < nums.length; ++i, index = i/k) {
                System.out.printf("%d %d %d %d\n", i, index, smallMap.get(index), nums[i]);
                if (smallMap.get(index) <= nums[i]) System.out.println("found");
            }

            return false;
        }

    }

}
*/