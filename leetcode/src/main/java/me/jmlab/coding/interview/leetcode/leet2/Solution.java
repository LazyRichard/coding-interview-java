package me.jmlab.coding.interview.leetcode.leet2;

import me.jmlab.coding.interview.leetcode.common.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String s1 = "";

        ListNode ll1 = l1;
        do {
            s1 = String.valueOf(ll1.val) + s1;
        } while ((ll1 = ll1.next) != null);

        String s2 = "";
        ListNode ll2 = l2;
        do {
            s2 = String.valueOf(ll2.val) + s2;
        } while ((ll2 = ll2.next) != null);

        int ret = Integer.parseInt(s1) + Integer.parseInt(s2);

        String a = String.valueOf(ret);

        ListNode result = null;
        for (int i = a.length() - 1; i > -1; i--) {
            result = new ListNode(Integer.parseInt(String.valueOf(a.charAt(i))), result);
        }

        return result;
    }
}
