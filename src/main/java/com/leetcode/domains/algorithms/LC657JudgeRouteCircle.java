
package com.leetcode.domains.algorithms;

import com.leetcode.util.Tuple;

public class LC657JudgeRouteCircle {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String moves = args.length > 0 ? args[0] : null;

        System.out.println(sol.judgeCircle(moves));
    }

    static class Solution {

        public boolean judgeCircle(String moves) {
            if (moves == null) return true;

            Tuple<Integer, Integer> pos = new Tuple<Integer, Integer>(0, 0);
            char move;

            for (int i = 0; i < moves.length(); ++i) {
                move = moves.charAt(i);
                switch (move) {
                    case 'U': pos.val1 += 1; break;
                    case 'D': pos.val1 -= 1; break;
                    case 'L': pos.val2 -= 1; break;
                    case 'R': pos.val2 += 1; break;
                }
            }

            return pos.val1 == 0 && pos.val2 == 0 ? true : false;
        }

    }

}