
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;

public class LC342PowerOfFour {

    public static void main(String[] args) {
        int num = ArgumentParser.parseArg(args, 0, new IntParser());
        System.out.println(new Solution().isPowerOfFour(num));
    }

    static class Solution {

        public boolean isPowerOfFour(int num) {
            if (num <= 0) return false;
            else if (num == 1) return true;

            int bits;
            boolean hasBit = (num & 1) == 1;

            for (int i = 2; i < 32; i+=2) {
                bits = num << 31 - i >>> 30;
                if (bits == 2 && hasBit || bits != 2 && bits > 0) return false;
                else if (bits == 2) hasBit = true;
            }

            return true;
        }

    }

}