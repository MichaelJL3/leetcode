
package com.leetcode.domains.algorithms;

public class LC344ReverseString {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("LC344ReverseString s");
            System.exit(2);
        }

        System.out.println(new Solution().reverseString(args[0]));
    }

    static class Solution {

        public String reverseString(String s) {
            char[] chars = new char[s.length()];

            for (int j = s.length() - 1, i = 0; j >= 0; ++i, --j) {
                chars[i] = s.charAt(j);
            }

            return new String(chars);
        }

    }

}