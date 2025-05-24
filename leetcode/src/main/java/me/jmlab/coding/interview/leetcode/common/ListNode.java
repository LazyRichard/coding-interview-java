package me.jmlab.coding.interview.leetcode.common;

import java.util.Objects;

public final class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this(val, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNodeBuilder builder(int val) {
        return new ListNodeBuilder(val);
    }

    public static final class ListNodeBuilder {

        private final int val;

        private ListNode next;

        public ListNodeBuilder(int val) {
            this.val = val;
        }

        public ListNodeBuilder next(ListNode next) {
            this.next = next;

            return this;
        }

        public ListNode build() {
            return new ListNode(val, next);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof ListNode)) return false;

        ListNode curr = this;
        ListNode currObj = (ListNode) obj;

        while (curr != null && currObj != null) {
            boolean comparison = curr.val == currObj.val;
            if (!comparison) return false;

            curr = curr.next;
            currObj = currObj.next;
        }

        return curr == null && currObj == null;
    }

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + ",next=" + next + "}";
    }
}
