
package com.leetcode.domains.algorithms;

import com.leetcode.io.ArgumentParser;
import com.leetcode.io.Display;
import com.leetcode.util.TreeNode;
import com.leetcode.util.parsers.string.IntParser;
import com.leetcode.util.parsers.string.StringParser;

public class LC669TrimABinarySearchTree {

    public static void main(String[] args) {
        IntParser parser = new IntParser();

        String arg = ArgumentParser.parseArg(args, 0, new StringParser());
        int left = ArgumentParser.parseArg(args, 1, parser);
        int right = ArgumentParser.parseArg(args, 2, parser);

        TreeNode<Integer> tree = ArgumentParser.<Integer>parseTree(arg, parser);

        Display.printTree(tree);
        Display.printTree(new Solution().trimBST(tree, left, right));
    }

    static class Solution {
    
        public TreeNode<Integer> trimBST(TreeNode<Integer> root, int L, int R) {
            if (root != null) {
                if (root.val < L) return trimBST(root.right, L, R);
                else if (root.val > R) return trimBST(root.left, L, R);
                root.left = trimBST(root.left, L, R);
                root.right = trimBST(root.right, L, R);
            }
            
            return root;
        }
        
    }

}