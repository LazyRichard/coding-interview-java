package me.jmlab.coding.interview.leetcode.leet46;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        return backtrack(nums);
    }

    private List<List<Integer>> backtrack(int[] nums) {
        return backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
    }

    private List<List<Integer>> backtrack(int[] nums, List<Integer> path, boolean[] visited) {
        List<List<Integer>> result = new ArrayList<>();

        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return result;
        }

        for (var i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            path.add(nums[i]);

            result.addAll(backtrack(nums, path, visited));

            visited[i] = false;
            path.removeLast();
        }

        return result;
    }
}
