package me.jmlab.coding.interview.leetcode.leet77;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combine(int n, int k) {
        return dfs(n, k, 1, new ArrayList<>());
    }

    private List<List<Integer>> dfs(int n, int k, int start, List<Integer> path) {
        List<List<Integer>> result = new ArrayList<>();

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return result;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            result.addAll(dfs(n, k, i + 1, path));
            path.removeLast();
        }

        return result;
    }
}
