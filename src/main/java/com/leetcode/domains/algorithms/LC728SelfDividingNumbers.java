
package com.leetcode.domains.algorithms;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;

public class LC728SelfDividingNumbers {

    public static void main(String[] args) {
        IntParser parser = new IntParser();

        int left = ArgumentParser.parseArg(args, 0, parser);
        int right = ArgumentParser.parseArg(args, 1, parser);

        System.out.println(new Solution().selfDividingNumbers(left, right));
    }

    static class Solution {
    
        private boolean selfDivides(int n) {
            int digits = n;
            int digit;
            
            while (digits != 0) {
                digit = digits % 10;
                if (digit == 0 || n % digit != 0) return false;
                digits /= 10;
            }
            
            return true;
        }
        
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> selfDiv = new ArrayList<Integer>();
            
            for (int i = left; i <= right; ++i) {
                if (selfDivides(i)) selfDiv.add(i);
            }
            
            return selfDiv;
        }
        
    }

}