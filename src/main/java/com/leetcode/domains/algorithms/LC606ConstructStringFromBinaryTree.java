
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.util.TreeNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC606ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        TreeNode<Integer> tree = ArgumentParser.<Integer>parseTree(arg, new IntParser());

        System.out.println(new Solution().tree2str(tree));
    }

    static class Solution {
    
        private final String EMPTY_NODE = "()";
        
        private String tree2strimpl(TreeNode<Integer> t) {
            if (t == null) return "";
            String left = tree2strimpl(t.left);
            String right = tree2strimpl(t.right);
            left = left.equals("") && !right.equals("") ? EMPTY_NODE : left;
            return "(" + t.val + left + right + ")"; 
        }
        
        public String tree2str(TreeNode<Integer> t) {
            if (t == null) return "";
            String left = tree2strimpl(t.left);
            String right = tree2strimpl(t.right);
            left = left.equals("") && !right.equals("") ? EMPTY_NODE : left;
            return t.val + left + right;
        }

    }

}