package me.jmlab.coding.interview.leetcode.common;

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
}
