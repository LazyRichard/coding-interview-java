package me.jmlab.coding.interview.leetcode.leet94;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import me.jmlab.coding.interview.leetcode.common.TreeNode;

public class Solution {

    public List<Integer> inorderTraversal(me.jmlab.coding.interview.leetcode.common.TreeNode root) {
        if (root == null) return Collections.emptyList();

        var result = new ArrayList<Integer>();

        for (TreeNode node : new TreeNodeInorderIterable(root)) {
            result.add(node.val);
        }

        return result;
    }

    static final class TreeNodeInorderIterable implements Iterable<me.jmlab.coding.interview.leetcode.common.TreeNode> {

        private final Stack<TreeNode> stack = new Stack<>();

        public TreeNodeInorderIterable(TreeNode root) {
            pushLeft(root);
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
                    pushLeft(node.right);

                    return node;
                }
            };
        }

        private void pushLeft(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
    }
}
