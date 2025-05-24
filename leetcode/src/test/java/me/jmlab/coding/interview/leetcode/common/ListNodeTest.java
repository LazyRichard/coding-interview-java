package me.jmlab.coding.interview.leetcode.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public final class ListNodeTest {

    static Stream<Arguments> equalSource() {
        return Stream.of(
                Arguments.of(new ListNode(1), new ListNode(1)),
                Arguments.of(new ListNode(1, new ListNode(2)), new ListNode(1, new ListNode(2))));
    }

    @ParameterizedTest
    @MethodSource("equalSource")
    void testEqualsAndHashCode(ListNode node1, ListNode node2) {
        assertEquals(node1, node2);
        assertEquals(node1.hashCode(), node2.hashCode());
    }
}
