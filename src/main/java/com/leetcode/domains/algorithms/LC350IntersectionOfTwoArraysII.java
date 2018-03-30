
package com.leetcode.domains.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC350IntersectionOfTwoArraysII {

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
            Map<Integer, Integer> numFreq = new HashMap<Integer,Integer>();
            ArrayList<Integer> tmpIntersection = new ArrayList<Integer>();
            int count;
            
            for (int num : nums1) {
                if (numFreq.containsKey(num)) {
                    numFreq.put(num, numFreq.get(num) + 1);
                } else {
                    numFreq.put(num, 1);
                }
            }

            for (int num : nums2) {
                if (numFreq.containsKey(num)) {
                    count = numFreq.get(num) - 1;

                    if (count > 0) {
                        numFreq.put(num, count);
                    } else {
                        numFreq.remove(num);
                    }

                    tmpIntersection.add(num);
                }
            }
            
            return tmpIntersection.toArray(new Integer[tmpIntersection.size()]);
        }

    }

}