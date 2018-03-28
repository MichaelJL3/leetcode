
package com.leetcode.domains.algorithms;

public class LC771JewelsAndStones {

    public static void main(String[] args) {
        Solution sol = new Solution();

        String str1 = args.length > 0 ? args[0] : null;
        String str2 = args.length > 1 ? args[1] : null;

        System.out.println(sol.numJewelsInStones(str1, str2));
    }

    static class Solution {

        private final boolean[] jewels = new boolean[255];

        private void encodeJewels(String j) {
            for (int i = 0; i < j.length(); ++i) {
                jewels[j.charAt(i)] = true;
            }
        }

        public int numJewelsInStones(String J, String S) {
            int count = 0;

            if (J == null || S == null) return count;

            encodeJewels(J);
            
            for (int i = 0; i < S.length(); ++i) {
                if (jewels[S.charAt(i)]) {
                    ++count;
                }
            }

            return count;
        }

    }

}
