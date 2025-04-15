package me.jmlab.coding.interview.leetcode.leet113;

import java.util.ArrayList;
import java.util.List;
import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        var result = new ArrayList<List<Integer>>();

        traverse(root, targetSum, new ArrayList<>(), result);

        return result;
    }

    private void traverse(TreeNode node, int target, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null && node.val == target) result.add(new ArrayList<>(path));

        traverse(node.left, target - node.val, path, result);
        traverse(node.right, target - node.val, path, result);

        path.remove(path.size() - 1);
    }
}
