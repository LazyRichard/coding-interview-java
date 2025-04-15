package me.jmlab.coding.interview.leetcode.leet112;

import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public boolean pathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode node, int target) {
        if (node == null) return false;
        if (node.left == null && node.right == null && target == node.val) return true;

        return dfs(node.left, target - node.val) || dfs(node.right, target - node.val);
    }
}
