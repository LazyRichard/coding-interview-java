package me.jmlab.coding.interview.leetcode.leet40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backtrack(candidates, target, 0, new ArrayList<>());
    }

    private List<List<Integer>> backtrack(int[] candidates, int target, int start, List<Integer> path) {
        if (target < 0) return Collections.emptyList();

        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return result;
        }

        for (int i = start; i < candidates.length; i++) {
            int c = candidates[i];
            path.add(c);
            result.addAll(backtrack(candidates, target - c, i + 1, path));
            path.removeLast();
        }

        return result;
    }
}
