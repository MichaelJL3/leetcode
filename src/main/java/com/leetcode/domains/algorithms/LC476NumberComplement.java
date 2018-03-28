
package com.leetcode.domains.algorithms;

public class LC476NumberComplement {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("LC476NumberComplement n");
            System.exit(2);
        }

        int num = Integer.parseInt(args[0]);

        System.out.println(new Solution().findComplement(num));
    }

    static class Solution {

        private int findLeadingBit(int num) {
            for (int i = 31; i >= 0; --i) {
                if ((num >> i & 1) == 1) return i;
            }

            return 0;
        }

        public int findComplement(int num) {
            int leadingBit = 31 - findLeadingBit(num);
            return ~num << leadingBit >> leadingBit;
        }

    }

}