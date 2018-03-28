
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
            int xor = a ^ b;
            int and = a & b;
            int tmp;

            while (and != 0) {
                tmp = xor;
                and <<= 1;
                xor ^= and;
                and = tmp & and;
            }

            return xor;
        }

    }

}
