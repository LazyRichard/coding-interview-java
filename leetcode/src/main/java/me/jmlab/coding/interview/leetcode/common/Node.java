package me.jmlab.coding.interview.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public final class Node {

    public final int val;

    public final List<Node> neighbors;

    public Node(int val) {
        this(val, new ArrayList<>());
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public static NodeBuilder builder(int val) {
        return new NodeBuilder(val);
    }

    public static final class NodeBuilder {

        private final int val;

        private List<Node> neighbors = new ArrayList<>();

        public NodeBuilder(int val) {
            this.val = val;
        }

        public NodeBuilder neighbor(Node neighbor) {
            neighbors.add(neighbor);

            return this;
        }

        public Node build() {
            return new Node(val, neighbors);
        }
    }
}
