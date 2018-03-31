
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.IntParser;

public class LC405ConvertANumberToHexidecimal {

    public static void main(String[] args) {
        Integer num = ArgumentParser.parseArg(args, 0, new IntParser());
        System.out.println(new Solution().toHex(num));
    }

    static class Solution {

        private char toHexChar(int hex) {
            return (char) (hex > 9 ? 'a' + hex - 10 : hex + '0');
        }

        public String toHex(int num) {
            String hex = "";   
            int i = 0;
            
            if (num == 0) return "0";

            while (num << i >>> 28 == 0 && i < 32) {
                i+=4;
            } 

            for (; i < 32; i+=4) {
                hex += toHexChar(num << i >>> 28);
            }

            return hex;
        }

    }

}