
package com.leetcode.domains.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC349IntersectionOfTwoArrays {

    public static void main(String[] args) {
        IntParser intParser = new IntParser();
        StringParser strParser = new StringParser();

        String arg1 = ArgumentParser.parseArg(args, 0, strParser);
        String arg2 = ArgumentParser.parseArg(args, 1, strParser);

        Integer[] nums1 = ArgumentParser.parseArray(Integer.class, arg1, intParser);
        Integer[] nums2 = ArgumentParser.parseArray(Integer.class, arg2, intParser);

        Display.printArray(new Solution().intersect(nums1, nums2));
    }

    static class Solution {

        public Integer[] intersect(Integer[] nums1, Integer[] nums2) {
            Map<Integer, Boolean> numFreq = new HashMap<Integer,Boolean>();
            Set<Integer> set = new HashSet<Integer>();
            
            for (int num : nums1) {
                numFreq.put(num, true);
            }

            for (int num : nums2) {
                if (numFreq.containsKey(num)) {
                    set.add(num);
                }
            }
            
            return set.toArray(new Integer[set.size()]);
        }

    }

}