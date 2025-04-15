package me.jmlab.coding.interview.leetcode.leet2;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    public static Stream<Arguments> methodSource() {
        return Stream.of(Arguments.of(Arrays.asList(2, 4, 3), Arrays.asList(5, 6, 4), Arrays.asList(7, 0, 8)));
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(List<Integer> l1, List<Integer> l2, List<Integer> expected) {
        ListNode ll1 = null;
        for (int i = l1.size() - 1; i > -1; i--) {
            ll1 = new ListNode(l1.get(i), ll1);
        }

        ListNode ll2 = null;
        for (int i = l2.size() - 1; i > -1; i--) {
            ll2 = new ListNode(l2.get(i), ll2);
        }

        var result = new Solution().addTwoNumbers(ll1, ll2);

        assertNotNull(result);
    }
}
