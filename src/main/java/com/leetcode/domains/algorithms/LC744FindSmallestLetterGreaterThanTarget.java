
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.CharParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC744FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        String strchars = ArgumentParser.parseArg(args, 0, new StringParser());

        char tgt = ArgumentParser.parseArg(args, 1, new CharParser());
        Character[] chars = ArgumentParser.parseArray(Character.class, strchars, new CharParser());

        System.out.println(new Solution().nextGreatestLetter(chars, tgt));
    }

    static class Solution {

        public char nextGreatestLetter(Character[] letters, char target) {
            if (letters == null || letters.length == 0) return 0;

            char minCharTgt = 255;
            char minChar = 255;

            for (char letter : letters) {
                if (letter < minCharTgt && letter > target) {
                    minCharTgt = letter;
                } else if (letter < minChar) {
                    minChar = letter;
                }
            }
            
            return minCharTgt == 255 ? minChar : minCharTgt;
        }

    }

}