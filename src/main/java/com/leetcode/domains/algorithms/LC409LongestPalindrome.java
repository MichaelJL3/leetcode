
package com.leetcode.domains.algorithms;

import java.util.Arrays;

public class LC409LongestPalindrome {

    public static void main(String[] args) {
        String arg = args.length > 0 ? args[0] : null;
        System.out.println(new Solution().longestPalindrome(arg)); 
    }

    static class Solution {

        public int longestPalindrome(String s) {
            int longest = 0;
            int[] countMap = new int[255];
            boolean loner = false;

            Arrays.fill(countMap, 0);
            for (int i = 0; i < s.length(); ++i) {
                ++countMap[s.charAt(i)];
            }

            for (int i = 0; i < 255; ++i) {
                if (countMap[i] % 2 != 0) {
                    if (!loner) {
                        loner = true;
                        ++longest;
                    }
                    --longest;
                }
                
                longest += countMap[i];
            }

            return longest;
        }

    }

}