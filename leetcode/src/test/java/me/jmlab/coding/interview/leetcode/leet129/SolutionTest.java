package me.jmlab.coding.interview.leetcode.leet129;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import me.jmlab.coding.interview.leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SolutionTest {

    public static final Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(
                        TreeNode.builder(4)
                                .left(TreeNode.builder(9).left(5).right(1))
                                .right(0)
                                .build(),
                        1026),
                Arguments.of(
                        TreeNode.builder(4)
                                .left(TreeNode.builder(9)
                                        .left(5)
                                        .right(TreeNode.builder(1).right(2)))
                                .right(0)
                                .build(),
                        5447));
        /*
        return Stream.of(
                Arguments.of(new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0)), 1026),
                Arguments.of(
                        new TreeNode(
                                4,
                                new TreeNode(9, new TreeNode(5), new TreeNode(1, null, new TreeNode(2))),
                                new TreeNode(0)),
                        5447));

         */
    }

    private static final Solution solution = new Solution();

    @ParameterizedTest
    @MethodSource("methodSource")
    public void test(TreeNode root, int expected) {

        var actual = solution.sumNumbers(root);

        assertEquals(expected, actual);
    }
}
