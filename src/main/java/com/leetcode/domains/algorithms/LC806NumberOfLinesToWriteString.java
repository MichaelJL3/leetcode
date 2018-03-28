
package com.leetcode.domains.algorithms;

import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;

public class LC806NumberOfLinesToWriteString {

    public static void main(String[] args) {
        Solution sol = new Solution();

        if (args.length < 2) {
            System.out.println("LC806NumberOfLinesToWriteString 1,2,...,n s");
            System.exit(2);
        }

        Integer[] widths = ArgumentParser.parseArray(Integer.class, args[0], new IntParser());
        String S = args[1];

        Display.printArray(sol.numberOfLines(widths, S));
    }

    static class Solution {

        private static final int maxwidth = 100;
        private static final int charoffset = 97;

        public Integer[] numberOfLines(Integer[] widths, String S) {
            int linewidth = 0;
            int charwidth = 0;
            int lines = S.length() > 0 ? 1 : 0;

            for (int i = 0; i < S.length(); ++i) {
                charwidth = widths[S.charAt(i) - charoffset];

                linewidth += charwidth;
                if (linewidth > maxwidth) {
                    ++lines;
                    linewidth = charwidth;
                }
            }

            return new Integer[] {lines, linewidth};
        }

    }

}
