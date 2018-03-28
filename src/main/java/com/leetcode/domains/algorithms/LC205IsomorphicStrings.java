
package com.leetcode.domains.algorithms;

public class LC205IsomorphicStrings {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String s = args.length > 0 ? args[0] : null;
        String t = args.length > 1 ? args[1] : null;

        System.out.println(sol.isIsomorphic(s, t));
    }

    static class Solution {

        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) return false;
    
            char sMap[] = new char[256];
            char tMap[] = new char[256];
            char sc;
            char st;
    
            for (int i = 0; i < 256; ++i) {
                sMap[i] = '\0';
                tMap[i] = '\0';
            }
    
            for (int i = 0; i < s.length(); ++i) {
                sc = s.charAt(i);
                st = t.charAt(i);
    
                if (sMap[sc] == '\0') {
                    if (tMap[st] != '\0') return false;
                    sMap[sc] = st;
                    tMap[st] = sc;
                } else if (sMap[sc] != st) {
                    return false;
                }
            }
    
            return true;
        }
    
    }

}