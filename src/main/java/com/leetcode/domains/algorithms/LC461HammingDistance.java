
package com.leetcode.domains.algorithms;

public class LC461HammingDistance {

    public static void main(String[] args) {
        Solution sol = new Solution();

        if (args.length < 2) {
            System.out.println("LC461HammingDistance x y");
            System.exit(2);
        }

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        System.out.println(sol.hammingDistance(x, y));
    }

    static class Solution {

        public int hammingDistance(int x, int y) {
            int sum = 0;

            for (int i = 0; i < 32; ++i) {
                sum += ((x >> i) & 1) ^ ((y >> i) & 1);
            }

            return sum;
        }

    }

}