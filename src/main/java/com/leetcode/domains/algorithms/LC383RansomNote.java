
package com.leetcode.domains.algorithms;

public class LC383RansomNote {

    public static void main(String[] args) {
        String note = args.length > 0 ? args[0] : null;
        String mag = args.length > 1 ? args[1] : null;
        System.out.println(new Solution().canConstruct(note, mag));
    }

    static class Solution {

        public boolean canConstruct(String ransomNote, String magazine) {
            if (magazine == null && ransomNote == null) return true;
            else if (magazine == null) return false;
            else if (ransomNote == null) return true;

            int[] magLetters = new int[255];
            char c;

            for (int i = 0; i < 255; ++i) {
                magLetters[i] = 0;
            }

            for (int i = 0; i < magazine.length(); ++i) {
                ++magLetters[magazine.charAt(i)];
            }

            for (int i = 0; i < ransomNote.length(); ++i) {
                c = ransomNote.charAt(i);
                --magLetters[c];
                if (magLetters[c] < 0) return false;
            }

            return true;
        }

    }

}