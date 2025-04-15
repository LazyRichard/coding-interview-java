package me.jmlab.coding.interview.leetcode.leet114;

import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public void flatten(TreeNode node) {
        if (node == null) return;

        flatten(node.left);
        flatten(node.right);

        if (node.left != null) {
            var tmp = node.right;

            node.right = node.left;
            node.left = null;

            var current = node.right;
            while (current.right != null) {
                current = current.right;
            }
            current.right = tmp;
        }
    }
}
