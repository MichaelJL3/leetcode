
package com.leetcode.domains.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class LC804UniqueMorseCodeWords {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.uniqueMorseRepresentations(args));
    }

    static class Solution {
        
        private static final Map<Character, String> morseTable;
        static {
            morseTable = new HashMap<Character, String>();
            morseTable.put('a', ".-");
            morseTable.put('b', "-...");
            morseTable.put('c', "-.-.");
            morseTable.put('d', "-..");
            morseTable.put('e', ".");
            morseTable.put('f', "..-.");
            morseTable.put('g', "--.");
            morseTable.put('h', "....");
            morseTable.put('i', "..");
            morseTable.put('j', ".---");
            morseTable.put('k', "-.-");
            morseTable.put('l', ".-..");
            morseTable.put('m', "--");
            morseTable.put('n', "-.");
            morseTable.put('o', "---");
            morseTable.put('p', ".--.");
            morseTable.put('q', "--.-");
            morseTable.put('r', ".-.");
            morseTable.put('s', "...");
            morseTable.put('t', "-");
            morseTable.put('u', "..-");
            morseTable.put('v', "...-");
            morseTable.put('w', ".--");
            morseTable.put('x', "-..-");
            morseTable.put('y', "-.--");
            morseTable.put('z', "--..");
        };

        private String morseCode(String word) {
            String morse = "";

            for (int i = 0; i < word.length(); ++i) {
                morse += morseTable.get(word.charAt(i));
            }

            return morse;
        }

        public int uniqueMorseRepresentations(String[] words) {
            if (words == null) return 0;

            Set<String> morseSet = new HashSet<String>();

            for (String word : words) {
                morseSet.add(morseCode(word));
            }

            return morseSet.size();
        }

    }

}