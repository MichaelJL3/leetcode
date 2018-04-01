
package com.leetcode.domains.algorithms;

import java.util.HashMap;
import java.util.Map;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC290WordPattern {

    public static void main(String[] args) {
        StringParser parser = new StringParser();

        String pattern = ArgumentParser.parseArg(args, 0, parser);
        String str = ArgumentParser.parseArg(args, 1, parser);

        System.out.println(new Solution().wordPattern(pattern, str));
    }

    static class Solution {

        public boolean wordPattern(String pattern, String str) {
            Map<String, Character> ptrnMap = new HashMap<String,Character>();
            String[] wordMap = new String['z' + 1];
            String[] words = str.split(" ");
            String word;
            String w;
            Character ptrn;
            char c;

            if (pattern.length() != words.length) return false;

            for (int i = 0; i < pattern.length(); ++i) {
                c = pattern.charAt(i);
                w = words[i];
                ptrn = ptrnMap.get(w);
                word = wordMap[c];

                if (word == null) {
                    wordMap[c] = w;
                } else if (!word.equals(w)) {
                    return false;
                }

                if (ptrn == null) {
                    ptrnMap.put(w, c);
                } else if (!(ptrn == c)) {
                    return false;
                }
            }

            return true;
        }

    }

}