/*
package com.leetcode.domains.algorithms;

public class LC371SumOfTwoIntegers {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("LC371SumOfTwoIntegers a b");
            System.exit(2);
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        System.out.println(new Solution().getSum(a, b));
    }

    static class Solution {

        public int getSum(int a, int b) {
            int c = a ^ b;
            int d = a & b;
            while (d != 0) {
                c ^= (d << 1);
            }
            return c;
        }

    }

}
*/