package me.jmlab.coding.interview.leetcode.leet46;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>풀이</h2>
 *
 * <p>이 문제는 DFS로 풀 수 있다. 예시의 입력값 {@code [1,2,3]}을 순회하면 다음과 같다.</p>
 *
 * <img src="{@docRoot}/resources/leet46/solution1-1.svg" alt="solution1-1"/>
 *
 * <p>여기서 {@code 1}에 해당하는 부분만 더 자세히 확인하면</p>
 *
 * <img src="{@docRoot}/resources/leet46/solution1-2.svg" alt="solution1-2"/>
 *
 * <p>여기서 {@code [1,1]}은 {@code 1}을 방문하는 시점에 {@code visited}를 통해 이미 방문했음을 알기 때문에 넘어간다.</p>
 */
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
