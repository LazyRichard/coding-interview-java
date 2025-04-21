package me.jmlab.coding.interview.leetcode.common;

import java.util.Objects;

public final class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;

    TreeNode() {
        this(0, null, null);
    }

    TreeNode(int val) {
        this(val, null, null);
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        Integer lv = left == null ? null : left.val;
        Integer rv = right == null ? null : right.val;
        return "TreeNode{" + "val=" + val + ", left=" + lv + ", right=" + rv + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    public static TreeNodeBuilder builder(int value) {
        return new TreeNodeBuilder(value);
    }

    public static TreeNode leaf(int val) {
        return new TreeNode(val);
    }

    public static final class TreeNodeBuilder {

        private int val;

        private TreeNode left;

        private TreeNode right;

        public TreeNodeBuilder(int val) {
            this.val = val;
        }

        public TreeNodeBuilder left(TreeNode value) {
            this.left = value;

            return this;
        }

        public TreeNodeBuilder left(TreeNodeBuilder builder) {
            return left(builder.build());
        }

        public TreeNodeBuilder left(int val) {
            return left(TreeNode.leaf(val));
        }

        public TreeNodeBuilder right(TreeNode value) {
            this.right = value;

            return this;
        }

        public TreeNodeBuilder right(TreeNodeBuilder builder) {
            return right(builder.build());
        }

        public TreeNodeBuilder right(int val) {
            return right(TreeNode.leaf(val));
        }

        public TreeNode build() {
            return new TreeNode(val, left, right);
        }
    }
}
