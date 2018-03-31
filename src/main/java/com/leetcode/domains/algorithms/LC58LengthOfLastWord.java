
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC58LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord((String)ArgumentParser.parseArg(args, 0, new StringParser())));
    }

    static class Solution {

        public int lengthOfLastWord(String s) {
            String[] words = s.split(" ");
            if (words.length == 0) return 0;
            return words[words.length - 1].length();
        }

    }

}