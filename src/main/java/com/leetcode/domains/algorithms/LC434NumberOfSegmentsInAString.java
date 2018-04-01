
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC434NumberOfSegmentsInAString {

    public static void main(String[] args) {
        System.out.println(new Solution().countSegments((String)ArgumentParser.parseArg(args, 0, new StringParser())));
    }

    static class Solution {

        public int countSegments(String s) {
            int count = 0;

            for (String sub : s.split(" ")) {
                System.out.println(sub);
                if (!sub.equals("")) ++count;
            }

            return count;
        }

    }

}