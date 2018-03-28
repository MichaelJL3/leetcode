
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;

public class LC4MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String arr1 = args.length > 0 ? args[0] : null;
        String arr2 = args.length > 1 ? args[1] : null;

        IntParser parser = new IntParser();
        Integer[] nums1 = ArgumentParser.parseArray(Integer.class, arr1, parser);
        Integer[] nums2 = ArgumentParser.parseArray(Integer.class, arr2, parser);

        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }

    static class Solution {
        public double findMedianSortedArrays(Integer[] nums1, Integer[] nums2) {
            int totalLength = nums1.length + nums2.length;
            int index = totalLength / 4;
            int leftIndex = index;
            int rightIndex = index;
            
            while(index > 0) {
                index /= 2;  
                System.out.println(index);
                System.out.println(leftIndex);
                System.out.println(rightIndex);
                System.out.printf("(%d: %d), (%d: %d)\n", leftIndex, nums1[leftIndex], rightIndex, nums2[rightIndex]);
                if (nums1[leftIndex] < nums2[rightIndex]) {
                    leftIndex += index;
                    rightIndex -= index;
                } else if (nums1[leftIndex] > nums2[rightIndex]) {
                    leftIndex -= index;
                    rightIndex += index;
                } else {
                    return 0;
                }  
            }

            System.out.println(index);
            System.out.println(leftIndex);
            System.out.println(rightIndex);

            return 0;
        }
    }

}