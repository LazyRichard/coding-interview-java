package me.jmlab.coding.interview.leetcode.leet100;

import java.util.Objects;
import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return p.val == q.val && Objects.equals(p.left, q.left) && Objects.equals(p.right, q.right);
    }
}
