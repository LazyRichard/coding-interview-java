package me.jmlab.coding.interview.leetcode.leet104;

import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(traverse(1, root.left), traverse(1, root.right));
    }

    private int traverse(int index, TreeNode curr) {
        if (curr == null) return index;

        return Math.max(traverse(index + 1, curr.left), traverse(index + 1, curr.right));
    }
}
