package me.jmlab.coding.interview.leetcode.leet2;

import java.math.BigInteger;
import me.jmlab.coding.interview.leetcode.common.ListNode;

/**
 * <h2>풀이</h2>
 *
 * <ol>
 *     <li>각 노드로부터 숫자 추출</li>
 *     <li>추출한 숫자 더하기</li>
 *     <li>더한 결과를 다시 {@link ListNode}로 변환</li>
 * </ol>
 */
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigInteger a = extract(l1);
        BigInteger b = extract(l2);

        BigInteger ret = a.add(b);

        String str = String.valueOf(ret);

        ListNode result = null;
        for (int i = 0; i < str.length(); i++) {
            result = new ListNode(Integer.parseInt(String.valueOf(str.charAt(i))), result);
        }

        return result;
    }

    private BigInteger extract(ListNode node) {
        StringBuilder sb = new StringBuilder();

        do {
            sb.insert(0, node.val);
        } while ((node = node.next) != null);

        return new BigInteger(sb.toString());
    }
}
