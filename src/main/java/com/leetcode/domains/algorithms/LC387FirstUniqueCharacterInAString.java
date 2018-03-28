
package com.leetcode.domains.algorithms;

public class LC387FirstUniqueCharacterInAString {

    public static void main(String[] args) {
        String arg = args.length > 0 ? args[0] : null;
        System.out.println(new Solution().firstUniqChar(arg));
    }

    static class Solution {

        public int firstUniqChar(String s) {
            if (s == null) return 0;

            int[] charMap = new int[255];

            for (int i = 0; i < 255; ++i) {
                charMap[i] = 0;
            }

            for (int i = 0; i < s.length(); ++i) {
                ++charMap[s.charAt(i)];
            }

            for (int i = 0; i < s.length(); ++i) {
                if (charMap[s.charAt(i)] == 1) return i;
            }

            return 0;
        }

    }

}