
package com.leetcode.domains.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LC412FizzBuzz {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = args.length > 0 ? Integer.parseInt(args[0]) : 0;
        
        System.out.println(sol.fizzBuzz(n));
    }

    static class Solution {

        public List<String> fizzBuzz(int n) {
            List<String> fb = new ArrayList<String>();
            
            for (int i = 1; i <= n; ++i) {

                if (i % 3 == 0 && i % 5 == 0) {
                    fb.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    fb.add("Fizz");
                } else if (i % 5 == 0) {
                    fb.add("Buzz");
                } else {
                    fb.add(Integer.toString(i));
                }
            }

            return fb;
        }

    }

}
