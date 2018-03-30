
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC551StudentAttendanceRecordI {

    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord((String) ArgumentParser.parseArg(args, 0, new StringParser())));
    }

    static class Solution {

        public boolean checkRecord(String s) {
            int lates = 0;
            char c;
            boolean absent = false;

            if (s == null) return true;

            for (int i = 0; i < s.length(); ++i) {
                c = s.charAt(i);

                if (c == 'A') {
                    if (absent) return false;
                    absent = true;
                    lates = 0;
                } else if(c == 'L') {
                    ++lates;
                    if (lates >= 3) return false;
                } else {
                    lates = 0;
                }
            }

            return true;
        }

    }

}