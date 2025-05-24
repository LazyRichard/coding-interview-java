package me.jmlab.coding.interview.leetcode.leet145;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SolutionTest {

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(1).right(TreeNode.builder(2).left(3)).build(), List.of(3, 2, 1)),
                Arguments.of(
                        TreeNode.builder(1)
                                .left(TreeNode.builder(2)
                                        .left(4)
                                        .right(TreeNode.builder(5).left(6).right(7)))
                                .right(TreeNode.builder(3)
                                        .right(TreeNode.builder(8).left(9)))
                                .build(),
                        List.of(4, 6, 7, 5, 2, 9, 8, 3, 1)),
                Arguments.of(null, Collections.emptyList()),
                Arguments.of(TreeNode.leaf(1), List.of(1)));
    }

    static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    void test(TreeNode root, List<Integer> expected) {
        var actual = solution.postOrderTraversal(root);

        assertEquals(expected, actual);
    }
}
