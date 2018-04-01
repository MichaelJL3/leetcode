
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.TreeNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC617MergeTwoBinaryTrees {

    public static void main(String[] args) {
        IntParser intParser = new IntParser();
        StringParser strParser = new StringParser();
        
        String arg1 = ArgumentParser.parseArg(args, 0, strParser);
        String arg2 = ArgumentParser.parseArg(args, 1, strParser);
        TreeNode<Integer> t1 = ArgumentParser.<Integer>parseTree(arg1, intParser);
        TreeNode<Integer> t2 = ArgumentParser.<Integer>parseTree(arg2, intParser);

        Display.printTree(t1);
        Display.printTree(t2);
        Display.printTree(new Solution().mergeTrees(t1, t2));
    }

    static class Solution {

        public TreeNode<Integer> mergeTrees(TreeNode<Integer> t1, TreeNode<Integer> t2) {
            TreeNode<Integer> root = null;
            
            if (t1 != null && t2 != null) {
                root = t1;
                root.val += t2.val;
                root.left = mergeTrees(t1.left, t2.left);
                root.right = mergeTrees(t1.right, t2.right);
            } else if (t1 != null) {
                root = t1;
            } else if (t2 != null) {
                root = t2;
            }
            
            return root;
        }

    }

}