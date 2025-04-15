package me.jmlab.coding.interview.leetcode.leet129;

import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public int sumNumbers(TreeNode root) {
        return traverse(root, 0);
    }

    private int traverse(TreeNode node, int sum) {
        if (node == null) return 0;

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) return sum;

        return traverse(node.left, sum) + traverse(node.right, sum);
    }
}
