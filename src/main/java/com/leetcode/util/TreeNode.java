
package com.leetcode.util;

public class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T x) { 
        val = x; 
    }

    @Override
    public String toString() {
        return String.format("(%s)", val.toString());
    }
}