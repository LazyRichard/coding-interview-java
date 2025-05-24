package me.jmlab.coding.interview.leetcode.util;

import java.util.Comparator;
import java.util.Iterator;
import me.jmlab.coding.interview.leetcode.common.ListNode;

public final class ListNodeComparator implements Comparator<ListNode> {

    private static final Comparator<ListNode> valueComparator = Comparator.comparingInt(node -> node.val);

    private static final Comparator<ListNode> INSTANCE = new ListNodeComparator();

    private ListNodeComparator() {}

    @Override
    public int compare(ListNode o1, ListNode o2) {
        Iterator<ListNode> l1 = new ListNodeIterable(o1).iterator();
        Iterator<ListNode> l2 = new ListNodeIterable(o2).iterator();

        while (l1.hasNext() && l2.hasNext()) {
            ListNode l1n = l1.next();
            ListNode l2n = l2.next();

            int comparison = valueComparator.compare(l1n, l2n);
            if (comparison != 0) return comparison;
        }

        if (l1.hasNext()) return 1;
        if (l2.hasNext()) return -1;

        return 0;
    }

    public static Comparator<ListNode> getInstance() {
        return INSTANCE;
    }
}
