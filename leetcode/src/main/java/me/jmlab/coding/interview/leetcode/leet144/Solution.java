package me.jmlab.coding.interview.leetcode.leet144;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import me.jmlab.coding.interview.leetcode.common.TreeNode;

class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        var result = new ArrayList<Integer>();

        for (TreeNode node : new TreeNodePreorderIterable(root)) {
            result.add(node.val);
        }

        return result;
    }

    static final class TreeNodePreorderIterable implements Iterable<TreeNode> {

        private final Stack<TreeNode> stack = new Stack<>();

        public TreeNodePreorderIterable(TreeNode root) {
            stack.push(root);
        }

        @Override
        public Iterator<TreeNode> iterator() {
            return new Iterator<>() {
                @Override
                public boolean hasNext() {
                    return !stack.isEmpty();
                }

                @Override
                public TreeNode next() {
                    var node = stack.pop();

                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);

                    return node;
                }
            };
        }
    }
}
