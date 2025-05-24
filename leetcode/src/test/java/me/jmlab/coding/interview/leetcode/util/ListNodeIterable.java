package me.jmlab.coding.interview.leetcode.util;

import java.util.Iterator;
import me.jmlab.coding.interview.leetcode.common.ListNode;

public final class ListNodeIterable implements Iterable<ListNode> {

    private final ListNode node;

    public ListNodeIterable(ListNode node) {
        this.node = node;
    }

    @Override
    public Iterator<ListNode> iterator() {
        return new ListNodeIterator(node);
    }

    private static final class ListNodeIterator implements Iterator<ListNode> {

        private ListNode node;

        public ListNodeIterator(ListNode node) {
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public ListNode next() {
            ListNode current = node;
            node = current.next;

            return current;
        }
    }
}
