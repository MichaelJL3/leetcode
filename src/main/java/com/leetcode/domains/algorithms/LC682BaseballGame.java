
package com.leetcode.domains.algorithms;

import java.util.Stack;

public class LC682BaseballGame {

    public static void main(String[] args) {
        String arg = args.length > 0 ? args[0] : "";
        System.out.println(new Solution().calPoints(arg.split(",")));
    }

    static class Solution {

        public int calPoints(String[] ops) {
            Stack<Integer> stack = new Stack<Integer>();
            int score = 0;
            int val;
            int tmp;

            for (String op : ops) {
                if (op.equals("D")) {
                    val = stack.peek() * 2;
                    score += val;
                    stack.push(val);
                } else if (op.equals("C")) {
                    score -= stack.pop();
                } else if (op.equals("+")) {
                    tmp = stack.pop();
                    val = tmp + stack.peek();
                    score += val;
                    stack.push(tmp);
                    stack.push(val);
                } else {
                    val = Integer.parseInt(op);
                    score += val;
                    stack.push(val);
                }
            }

            return score;
        }

    }

}