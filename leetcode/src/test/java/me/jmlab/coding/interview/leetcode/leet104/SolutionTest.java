package me.jmlab.coding.interview.leetcode.leet104;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(3)
                                .left(9)
                                .right(TreeNode.builder(20).left(15).right(7))
                                .build(),
                        3),
                Arguments.of(TreeNode.builder(1).right(TreeNode.leaf(2)).build(), 2));
    }

    static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(TreeNode root, int expected) {
        var actual = solution.maxDepth(root);

        assertEquals(expected, actual);
    }
}
