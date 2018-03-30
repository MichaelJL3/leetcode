
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC415AddStrings {

    public static void main(String[] args) {
        StringParser parser = new StringParser();
        String num1 = ArgumentParser.parseArg(args, 0, parser);
        String num2 = ArgumentParser.parseArg(args, 1, parser);

        System.out.println(new Solution().addStrings(num1, num2));
    }

    static class Solution {

        private static int toInt(char c) {
            return c - '0';
        }

        private static char toChar(int c) {
            return (char)(c + '0');
        }

        public String addStrings(String num1, String num2) {
            if (num1 == null) return num2;
            else if (num2 == null) return num1;

            String sum = "";
            int carry = 0;
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int digit;

            for (; i >= 0 && j >= 0; --i, --j) {
                digit = toInt(num1.charAt(i)) + toInt(num2.charAt(j)) + carry;
                carry = (digit > 9) ? 1 : 0;
                digit %= 10;

                sum = toChar(digit) + sum;
            }

            for (; i >= 0 && carry != 0; --i) {
                digit = toInt(num1.charAt(i)) + carry;
                carry = (digit > 9) ? 1 : 0;
                digit %= 10;

                sum = toChar(digit) + sum;
            }

            for (; j >= 0 && carry != 0; --j) {
                digit = toInt(num2.charAt(j)) + carry;
                carry = (digit > 9) ? 1 : 0;
                digit %= 10;

                sum = toChar(digit) + sum;
            }

            if (carry != 0) sum = toChar(carry) + sum;
            else if (i >= 0) sum = num1.substring(0, i + 1) + sum;
            else if (j >= 0) sum = num2.substring(0, j + 1) + sum;

            return sum;
        }

    }

}