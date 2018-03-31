
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC345ReverseVowelsOfAString {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels((String) ArgumentParser.parseArg(args, 0, new StringParser())));
    }

    static class Solution {

        private boolean isVowel(char c) {
            return c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u' 
                || c == 'A' || c =='E' || c == 'I' || c == 'O' || c == 'U';
        }

        public String reverseVowels(String s) {
            if (s == null) return null;

            char[] chars = new char[s.length()];
            char char1, char2;
            boolean vowel1, vowel2;

            for (int i = 0, j = s.length() - 1; i <= j; ++i, --j) {
                char1 = s.charAt(i);
                char2 = s.charAt(j);
                vowel1 = isVowel(char1);
                vowel2 = isVowel(char2);

                if (vowel1 && vowel2) {
                    chars[i] = char2;
                    chars[j] = char1;
                } else if (vowel1) {
                    --i;
                    chars[j] = char2;
                } else if (vowel2) {
                    ++j;
                    chars[i] = char1;
                } else {
                    chars[i] = char1;
                    chars[j] = char2;
                }
            }

            return String.copyValueOf(chars);
        }

    }

}