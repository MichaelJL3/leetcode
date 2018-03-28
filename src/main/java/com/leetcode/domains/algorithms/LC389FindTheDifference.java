
package com.leetcode.domains.algorithms;

public class LC389FindTheDifference {

    public static void main(String[] args) {
        String s = args.length > 0 ? args[0] : null;
        String t = args.length > 1 ? args[1] : null;
        System.out.println(new Solution().findTheDifference(s, t));
    }

    static class Solution {

        public char findTheDifference(String s, String t) {
            int[] charsS = new int[255];
            int[] charsT = new int[255];

            for (int i = 'a'; i <= 'z'; ++i) {
                charsS[i] = 0;
                charsT[i] = 0;
            }

            for (int i = 0; i < s.length(); ++i) {
                ++charsS[s.charAt(i)];
            }

            for (int i = 0; i < t.length(); ++i) {
                ++charsT[t.charAt(i)];
            }

            for (int i = 'a'; i <= 'z'; ++i) {
                if (Math.abs(charsS[i] - charsT[i]) == 1) return (char) i;
            }

            return 0;
        }

    }

}