
package com.leetcode.domains.algorithms;

public class LC520DetectCapital {

    public static void main(String[] args) {
        String arg = args.length > 0 ? args[0] : null;
        System.out.println(new Solution().detectCapitalUse(arg));
    }

    static class Solution {

        public boolean detectCapitalUse(String word) {
            if (word == null || word.length() <= 1) return true;
            
            boolean hasUpper = false;
            boolean hasLower = Character.isLowerCase(word.charAt(0));

            for (int i = 1; i < word.length(); ++i) {
                if (Character.isLowerCase(word.charAt(i))) hasLower = true;
                else hasUpper = true;
            }

            return (hasLower && !hasUpper) || (hasUpper && !hasLower);
        }

    }

}