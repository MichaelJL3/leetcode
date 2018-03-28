
package com.leetcode.domains.algorithms;

public class LC693BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        int num = args.length > 0 ? Integer.parseInt(args[0]) : 0;
        System.out.println(new Solution().hasAlternatingBits(num));
    }

    static class Solution {

        private int firstActiveBit(int n) {
            for (int i = 0; i < 32; ++i) {
                if (n << i >>> 31 == 1) return 32 - i;
            }
            return 0;
        }

        public boolean hasAlternatingBits(int n) {
            int lastIndex = firstActiveBit(n);
            int firstBit = n & 1;
            int bit;

            for (int i = 1; i < lastIndex; i++) {
                bit = n >> i & 1;
                if (i % 2 == 0) {
                    if (bit != firstBit) return false;
                } else if (bit == firstBit) return false;
            }

            return true;
        }

    }

}