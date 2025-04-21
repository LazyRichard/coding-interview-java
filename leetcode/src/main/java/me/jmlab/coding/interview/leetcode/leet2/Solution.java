package me.jmlab.coding.interview.leetcode.leet2;

import me.jmlab.coding.interview.leetcode.common.ListNode;

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int a = extract(l1);
        int b = extract(l2);

        int ret = a + b;

        String str = String.valueOf(ret);

        ListNode result = null;
        for (int i = str.length() - 1; i > -1; i--) {
            result = new ListNode(Integer.parseInt(String.valueOf(str.charAt(i))), result);
        }

        return result;
    }

    private int extract(ListNode node) {
        StringBuilder sb = new StringBuilder();

        do {
            sb.insert(0, node.val);
        } while ((node = node.next) != null);

        return Integer.parseInt(sb.toString());
    }
}
