
package com.leetcode.domains.algorithms;

import com.leetcode.io.Display;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC500KeyboardRow {

    public static void main(String[] args) {
        Display.printArray(new Solution().findWords(args));
    }

    static class Solution {

        private static final Map<Character, Integer> rowMap;
        static {
            rowMap = new HashMap<Character, Integer>();
            rowMap.put('q', 1); rowMap.put('Q', 1);
            rowMap.put('w', 1); rowMap.put('W', 1);
            rowMap.put('e', 1); rowMap.put('E', 1);
            rowMap.put('r', 1); rowMap.put('R', 1);
            rowMap.put('t', 1); rowMap.put('T', 1);
            rowMap.put('y', 1); rowMap.put('Y', 1);
            rowMap.put('u', 1); rowMap.put('U', 1);
            rowMap.put('i', 1); rowMap.put('I', 1);
            rowMap.put('o', 1); rowMap.put('O', 1);
            rowMap.put('p', 1); rowMap.put('P', 1);
            rowMap.put('a', 2); rowMap.put('A', 2);
            rowMap.put('s', 2); rowMap.put('S', 2);
            rowMap.put('d', 2); rowMap.put('D', 2);
            rowMap.put('f', 2); rowMap.put('F', 2);
            rowMap.put('g', 2); rowMap.put('G', 2);
            rowMap.put('h', 2); rowMap.put('H', 2);
            rowMap.put('j', 2); rowMap.put('J', 2);
            rowMap.put('k', 2); rowMap.put('K', 2);
            rowMap.put('l', 2); rowMap.put('L', 2);
            rowMap.put('z', 3); rowMap.put('Z', 3);
            rowMap.put('x', 3); rowMap.put('X', 3);
            rowMap.put('c', 3); rowMap.put('C', 3);
            rowMap.put('v', 3); rowMap.put('V', 3);
            rowMap.put('b', 3); rowMap.put('B', 3);
            rowMap.put('n', 3); rowMap.put('N', 3);
            rowMap.put('m', 3); rowMap.put('M', 3);
        }

        private boolean rowWord(String word) {
            int row;
            int initRow = rowMap.get(word.charAt(0));

            for (int i = 1; i < word.length(); ++i) {
                row = rowMap.get(word.charAt(i));
                if (row != initRow) return false;
            }

            return true;
        }

        public String[] findWords(String[] words) {
            ArrayList<String> rowWords = new ArrayList<String>();

            for (String word : words) {
                if (rowWord(word)) {
                    rowWords.add(word);
                }
            }

            return rowWords.toArray(new String[rowWords.size()]);
        }

    }

}