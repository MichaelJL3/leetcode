package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;

public class LC762PrimeNumberOfSetBitsInBinaryRepresentation {

    public static void main(String[] args) {
        IntParser parser = new IntParser();
        int L = ArgumentParser.parseArg(args, 0, parser);
        int R = ArgumentParser.parseArg(args, 1, parser);

        System.out.println(new Solution().countPrimeSetBits(L, R));
    }
    
    static class Solution {

        private static boolean[] primeBits = {
            //  0      1     2     3      4     5      6     7      8
            false, false, true, true, false, true, false, true, false,
            //  9     10    11     12    13     14     15     16    17
            false, false, true, false, true, false, false, false, true,
            // 18    19     20     21     22    23     24     25     26
            false, true, false, false, false, true, false, false, false,
            // 27     28    29     30    31     32
            false, false, true, false, true, false 
        };
        
        private int setBits(int n) {
            int bits = 0;
            
            for (int shifted = n ; shifted != 0; shifted >>>= 1) {
                bits += shifted & 1;
            }
            
            return bits;
        }

        public int countPrimeSetBits(int L, int R) {
            int primeBitCounts = 0;
            
            for (; L <= R; ++L) {
                if (primeBits[setBits(L)]) ++primeBitCounts;
            }
            
            return primeBitCounts;
        }

    }

}