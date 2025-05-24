package me.jmlab.coding.interview.leetcode.leet100;

import java.util.Objects;
import me.jmlab.coding.interview.leetcode.common.TreeNode;

/**
 * <h2>풀이</h2>
 *
 * <p>이 문제는 재귀를 통해 해결할 수 있음. 아래 케이스들을 확인하면 됨</p>
 *
 * <ul>
 *     <li>값 필드가 같은가?</li>
 *     <li>왼쪽 노드가 같은가? (재귀 호출)</li>
 *     <li>오른쪽 노드가 같은가? (재귀 호출)</li>
 * </ul>
 *
 * <p>아래와 같은 경우를 생각해볼 수 있다.</p>
 *
 * <ol>
 *     <li>{@code p}와 {@code q}가 모두 {@code null}인 경우</li>
 *     <li>{@code p} 또는 {@code q}가 {@code null}인 경우</li>
 *     <li>{@code p}와 {@code q} 모두 {@code null}이 아닌 경우</li>
 * </ol>
 *
 * <p>첫 번째 케이스의 경우에는 모두 {@code null}이기 때문에 {@code true}라 할 수 있다.</p>
 *
 * <p>두 번째 케이스는 양 쪽 중 하나가 {@code null}이기 때문에 {@code false}를 반환해야 한다</p>
 *
 * <p>마지막 케이스는 양 쪽 모두 값이 있으므로 양 쪽의 {@code val}이 같은지 그리고 왼쪽 노드가 같은지 오른쪽 노드가 같은지 검사해야 한다.
 * 값은 {@code p.val == q.val}로 검사할 수 있고, 왼쪽 또는 오른쪽은 {@code isSameTree(p.left, q.left)}로 검사할 수 있다.</p>
 *
 */
class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
