
package com.leetcode.domains.algorithms;

public class LC557ReverseWordsInAStringIII {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords(String.join(" ", args)));
    }

    static class Solution {

        private String reverseString(String s) {
            char[] chars = new char[s.length()];

            for (int j = s.length() - 1, i = 0; j >= 0; ++i, --j) {
                chars[i] = s.charAt(j);
            }

            return new String(chars);
        }

        public String reverseWords(String s) {
            String[] words = s.split(" ");

            for (int i = 0; i < words.length; ++i) {
                words[i] = reverseString(words[i]);
            }

            return String.join(" ", words);
        }

    }

}