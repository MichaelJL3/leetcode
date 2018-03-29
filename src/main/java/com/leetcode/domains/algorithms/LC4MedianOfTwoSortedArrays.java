
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.Comparators;
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
            int index = (int) Math.ceil(totalLength / 4.0);
            int leftIndex = index - 1;
            int rightIndex = index - 1;
            int left;
            int right;

            //edge cases - 
                //disproportoniate sizes - not handled yet
                //on even length both med values on one side - not handled yet
            
            while(index > 0) {
                index /= 2;  
                left = nums1[leftIndex];
                right = nums2[rightIndex];

                System.out.println(index);
                System.out.printf("(%d: %d), (%d: %d)\n", leftIndex, left, rightIndex, right);
                if (left < right) {
                    leftIndex += index;
                    rightIndex -= index;
                } else if (left > right) {
                    rightIndex += index;
                    leftIndex -= index;
                } else {
                    return left;
                }
            }

            System.out.printf("(%d: %d), (%d: %d)\n", leftIndex, nums1[leftIndex], rightIndex, nums2[rightIndex]);
            if (totalLength == 0) {
                return 0;
            } else if (totalLength % 2 == 0) {
                if (nums1[leftIndex] > nums2[rightIndex]) {
                    if (leftIndex + 1 != nums1.length) {
                        return (nums1[leftIndex] + nums1[leftIndex + 1]) / 2.0;
                    } else {
                        return (nums1[leftIndex] + nums2[rightIndex + 1]) / 2.0;
                    }
                } else if (nums1[leftIndex] < nums2[rightIndex]) {
                    if (rightIndex + 1 != nums2.length) {
                        return (nums2[rightIndex] + nums2[rightIndex + 1]) / 2.0;
                    } else {
                        return (nums2[rightIndex] + nums1[leftIndex + 1]) / 2.0;
                    }
                } else {
                    return nums1[leftIndex];
                }
            } else {
                return Comparators.max(nums1[leftIndex], nums2[rightIndex]);
            }
        }
    }

}