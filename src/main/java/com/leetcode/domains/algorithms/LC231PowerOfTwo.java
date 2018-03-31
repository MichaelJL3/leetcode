
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;

public class LC231PowerOfTwo {

    public static void main(String[] args) {
        Integer n = ArgumentParser.parseArg(args, 0, new IntParser());
        System.out.println(new Solution().isPowerOfTwo(n));
    }

    static class Solution {

        public boolean isPowerOfTwo(int n) {
            int sum = 0;

            if (n < 0) return false;

            for (int i = 0; i < 32; ++i) {
                sum += n >> i & 1;
            }

            return sum == 1;
        }

    }

}