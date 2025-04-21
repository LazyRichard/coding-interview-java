package me.jmlab.coding.interview.leetcode.leet39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return dfs(candidates, target, 0, new ArrayList<>());
    }

    private List<List<Integer>> dfs(int[] candidates, int target, int start, List<Integer> path) {
        if (target < 0) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return result;
        }

        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            result.addAll(dfs(candidates, target - candidates[i], i, path));
            path.removeLast();
        }

        return result;
    }
}
