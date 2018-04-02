
package com.leetcode.domains.algorithms;

import java.util.HashSet;
import java.util.Set;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC575DistributeCandies {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        Integer[] candies = ArgumentParser.parseArray(Integer.class, arg, new IntParser());

        System.out.println(new Solution().distributeCandies(candies));
    }

    static class Solution {
        
        public int distributeCandies(Integer[] candies) {
            Set<Integer> candySet = new HashSet<Integer>();
            int per = candies.length / 2;
            
            for (int candy : candies) {
                candySet.add(candy);
            }
            
            return candySet.size() > per ? per : candySet.size();
        }

    }

}