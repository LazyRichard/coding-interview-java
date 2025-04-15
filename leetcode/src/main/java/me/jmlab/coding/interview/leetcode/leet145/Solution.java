package me.jmlab.coding.interview.leetcode.leet145;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();

        var result = new ArrayList<Integer>();

        for (TreeNode node : new TreeNodePostorderIterable(root)) {
            result.add(node.val);
        }

        return result;
    }

    static final class TreeNodePostorderIterable implements Iterable<TreeNode> {

        private final Stack<TreeNode> stack = new Stack<>();
        private final Stack<TreeNode> result = new Stack<>();

        public TreeNodePostorderIterable(TreeNode root) {
            stack.push(root);

            traverse();
        }

        @Override
        public Iterator<TreeNode> iterator() {
            return new Iterator<>() {
                @Override
                public boolean hasNext() {
                    return !result.isEmpty();
                }

                @Override
                public TreeNode next() {
                    return result.pop();
                }
            };
        }

        private void traverse() {
            while (!stack.isEmpty()) {
                var node = stack.pop();

                result.push(node);

                if (node.left != null) stack.push(node.left);
                if (node.right != null) stack.push(node.right);
            }
        }
    }
}
