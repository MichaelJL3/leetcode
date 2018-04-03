
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.TreeNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC404SumOfLeftLeaves {

    public static void main(String[] args) {
        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        TreeNode<Integer> tree = ArgumentParser.<Integer>parseTree(arg, new IntParser());

        Display.printTree(tree);
        System.out.println(new Solution().sumOfLeftLeaves(tree));
    }

    static class Solution {

        private int leftTraverse(TreeNode<Integer> root) {
            if (root == null) return 0;
            else if (root.left == null && root.right == null) return root.val;
            return sumOfLeftLeaves(root.right) + leftTraverse(root.left);
        }
        
        public int sumOfLeftLeaves(TreeNode<Integer> root) {
            if (root == null) return 0;
            return sumOfLeftLeaves(root.right) + leftTraverse(root.left);
        }

    }

}