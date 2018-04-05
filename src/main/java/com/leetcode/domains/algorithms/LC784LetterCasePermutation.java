
package com.leetcode.domains.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC784LetterCasePermutation {

    public static void main(String[] args) {
        String S = ArgumentParser.parseArg(args, 0, new StringParser());
        System.out.println(new Solution().letterCasePermutation(S));
    }

    static class Solution {

        private List<String> permutations;

        private void pushToAllMembers(List<String> list, char c) {
            ListIterator<String> iterator = list.listIterator();

            while (iterator.hasNext()){
                iterator.set(iterator.next() + c);
            }
        }

        public List<String> letterCasePermutation(String S) {
            List<String> temp = new LinkedList<String>();
            char c;

            permutations = new LinkedList<String>();
            
            permutations.add("");
            for (int i = 0; i < S.length(); ++i) {
                c = S.charAt(i);
                
                if (Character.isLowerCase(c) || Character.isUpperCase(c)) {
                    temp.clear();
                    temp.addAll(permutations);
                    pushToAllMembers(temp, Character.isUpperCase(c) ? 
                        Character.toLowerCase(c) : Character.toUpperCase(c));
                    pushToAllMembers(permutations, c);
                    permutations.addAll(temp);
                } else {
                    pushToAllMembers(permutations, c);
                }
            }

            return permutations;
        }
    }
}