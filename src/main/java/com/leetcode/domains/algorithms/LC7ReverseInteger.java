 
package com.leetcode.domains.algorithms;

import java.lang.Math;

public class LC7ReverseInteger {

	public static void main(String[] args) {
        Solution sol = new Solution();
        int x = 0;

		if (args.length > 0) {
			x = Integer.parseInt(args[0]);
		}

		System.out.println(sol.reverse(x));
	}

    static class Solution {

        private final int maxInt = 2147483647;
    
        private Boolean hasOverflowed(long x) {
            return x > maxInt ? true : false;
        }
        
        public int reverse(int x) {
            long input = Math.abs((long)x);
            long output = 0;
            int checked = 0;
            Boolean isneg = x < 0 ? true : false;
    
            while(input != 0) {
                output *= 10;
                output += input % 10;
                input /= 10;
            }
    
            checked = hasOverflowed(output) == true ? 0 : (int) output;
    
            return isneg == true ?  0 - checked : checked;
        }
        
    }

}
