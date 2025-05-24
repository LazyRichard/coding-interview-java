package me.jmlab.coding.interview.leetcode.leet101;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(1)
                                .left(TreeNode.builder(2).left(3).right(4))
                                .right(TreeNode.builder(2).left(4).right(3))
                                .build(),
                        true),
                Arguments.of(
                        TreeNode.builder(1)
                                .left(TreeNode.builder(2).right(3))
                                .right(TreeNode.builder(2).right(3))
                                .build(),
                        false),
                Arguments.of(TreeNode.leaf(1), true),
                Arguments.of(TreeNode.builder(1).left(2).right(3).build(), false));
    }

    private Solution solution;

    @BeforeEach
    void beforeEach() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(TreeNode root, boolean expected) {
        var actual = solution.isSymmetric(root);

        assertEquals(expected, actual);
    }
}
