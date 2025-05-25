package me.jmlab.coding.interview.leetcode.leet133;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import me.jmlab.coding.interview.leetcode.common.Node;

class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (node.neighbors.isEmpty()) return new Node(node.val);

        return cloneInternal(node, node.neighbors.getFirst(), Collections.emptyMap());
    }

    private Node cloneInternal(Node from, Node to, Map<Integer, Node> map) {
        Node clone = map.getOrDefault(from.val, new Node(from.val));

        ArrayList<Node> neighbors = new ArrayList<>();
        for (Node neighbor : from.neighbors) {
            neighbors.add(cloneInternal(from, neighbor, map));
            neighbors.add(cloneInternal(to, neighbor, map));
        }

        return clone;
    }
}
