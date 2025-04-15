package me.jmlab.coding.interview.leetcode.leet101;

import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;

        return isSymmetricInternal(root.left, root.right);
    }

    private boolean isSymmetricInternal(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        if ((p.left != null && q.right == null) || (p.left == null && q.right != null)) return false;
        if ((p.right != null && q.left == null) || (p.right == null && q.left != null)) return false;

        if (p.left != null && (p.left.val != q.right.val)) return false;
        if (p.right != null && (p.right.val != q.left.val)) return false;

        return isSymmetricInternal(p.left, q.right) && isSymmetricInternal(p.right, q.left);
    }
}
