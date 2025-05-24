package me.jmlab.coding.interview.leetcode.common;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TreeNodeTest {

    static Stream<Arguments> equalSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(1).left(2).right(3).build(),
                        TreeNode.builder(1).left(2).right(3).build()),
                Arguments.of(TreeNode.leaf(2), TreeNode.leaf(2)));
    }

    @ParameterizedTest
    @MethodSource("equalSource")
    void testEqualsAndHashCode(TreeNode a, TreeNode b) {
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }
}
