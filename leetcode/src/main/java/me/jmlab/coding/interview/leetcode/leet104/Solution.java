package me.jmlab.coding.interview.leetcode.leet104;

import me.jmlab.coding.interview.leetcode.common.TreeNode;

/**
 * <h2>풀이</h2>
 *
 * <p>재귀로 해결할 수 있음</p>
 *
 * <p>각 노드를 탐색하면서 값을 하나 씩 증가시키면 됨</p>
 */
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        return Math.max(traverse(1, root.left), traverse(1, root.right));
    }

    private int traverse(int index, TreeNode curr) {
        if (curr == null) return index;

        return Math.max(traverse(index + 1, curr.left), traverse(index + 1, curr.right));
    }
}
