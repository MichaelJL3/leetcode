
package com.leetcode.domains.algorithms;

public class LC70ClimbingStairs {

    public static void main(String[] args) {
        Solution sol = new Solution();

        if (args.length < 0) {
            System.out.println("LC70ClimbingStairs n");
            System.exit(2);
        }

        int n = Integer.parseInt(args[0]);
        System.out.println(sol.climbStairs(n));
    }

    static class Solution {

        public int climbStairs(int n) {
            int fibM2 = 1;
            int fibM1 = 1;
            int fib = 0;
    
            if (n <= 1) return 1;
    
            for (int i = 2; i <= n; ++i) {
                fib = fibM2 + fibM1;
                fibM2 = fibM1;
                fibM1 = fib;
            }
    
            return fib;
        }
        
    }    

}
