package me.jmlab.coding.interview.leetcode.leet39;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h2>Solution</h2>
 *
 * <p>아래 케이스를 기준으로 진행한다.</p>
 *
 * <pre>
 *   <strong>Input:</strong> candidates = [2,5,2,1,2], target = 5
 *   <strong>Output:</strong>
 *     [
 *       [1,2,2],
 *       [5]
 *     ]
 * </pre>
 *
 * <p><strong>첫 번째로 중복 제거를 쉽게 하기 위해 정렬을 한다.</strong></p>
 *
 * <ul>
 *     <li>{@code [1, 2, 2, 2, 5]}</li>
 * </ul>
 *
 * <img src="{@docRoot}/resources/leet40/solution1-1.svg" alt="solution1-1"/>
 *
 */
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
