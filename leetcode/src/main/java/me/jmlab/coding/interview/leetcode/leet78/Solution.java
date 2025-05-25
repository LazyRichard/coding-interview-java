package me.jmlab.coding.interview.leetcode.leet78;

import java.util.ArrayList;
import java.util.List;

/**
 * <h2>풀이</h2>
 *
 * <p>이 문제는 DFS를 사용해 모든 가능한 부분 집합을 계산한다.</p>
 * <ol>
 *     <li>모든 부분 집합을 저장할 리스트를 생성한다</li>
 *     <li>현재 부분 집합을 저장할 리스트를 생성한다</li>
 *     <li>현재 부분 집합을 리스트에 추가한다</li>
 *     <li>현재 인덱스부터 시작하여 모든 숫자를 반복한다</li>
 *     <li>재귀 호출이 끝난 후에는 마지막에 추가한 숫자를 제거하여 상태를 복원한다.</li>
 * </ol>
 *
 */
class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        return dfs(nums, 0, new ArrayList<>());
    }

    private List<List<Integer>> dfs(int[] nums, int index, List<Integer> path) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            result.addAll(dfs(nums, i + 1, path));
            path.removeLast();
        }

        return result;
    }
}
