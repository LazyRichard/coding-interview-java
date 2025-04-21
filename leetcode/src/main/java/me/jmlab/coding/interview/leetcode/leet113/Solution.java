package me.jmlab.coding.interview.leetcode.leet113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.jmlab.coding.interview.leetcode.common.TreeNode;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, new ArrayList<>());
    }

    private List<List<Integer>> dfs(TreeNode head, int targetSum, List<Integer> path) {
        if (head == null) return Collections.emptyList();

        path.add(head.val);
        List<List<Integer>> result = new ArrayList<>();
        if (head.left == null && head.right == null && targetSum == head.val) {
            result.add(new ArrayList<>(path));
        } else {
            result.addAll(dfs(head.left, targetSum - head.val, path));
            result.addAll(dfs(head.right, targetSum - head.val, path));
        }
        path.removeLast();

        return result;
    }
}
