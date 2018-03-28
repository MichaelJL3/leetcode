
package com.leetcode.domains.algorithms;

public class LC796RotateString {

    public static void main(String[] args) {
        Solution sol = new Solution();

        if (args.length < 2) {
            System.out.println("LC796RotateString a b");
            System.exit(2);
        }

        String a = args[0];
        String b = args[1];

        System.out.println(sol.rotateString(a, b));
    }

    static class Solution {

        public boolean rotateString(String a, String b) {
            if (a.length() != b.length()) return false;
            else if (a.equals(b)) return true;
            
            String tmp;
            char start = b.charAt(0);
            char c;

            for (int i = 0; i < a.length(); ++i) {
                c = a.charAt(i);
                if (start == c) {
                    tmp = a.substring(i) + a.substring(0, i);
                    if (tmp.equals(b)) return true;
                }
            }

            return false;
        }
        
    }

}